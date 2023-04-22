package ai.petthinq.catectivesbackend.dao.impl;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ai.petthinq.catectivesbackend.dao.UserDAO;
import ai.petthinq.catectivesbackend.entity.User;
import jakarta.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public int save(User user) {
		Session session = entityManager.unwrap(Session.class);
		
		String password = user.getPassword();
		BasicPasswordEncryptor passwordEnc = new BasicPasswordEncryptor();
		String encPassword = passwordEnc.encryptPassword(password);
		user.setPassword(encPassword);
		session.persist(user);
		return user.getId();
	}
	
	@Override
	public User findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(User.class, id);
	}
	
	@Override
	public List<User> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		SelectionQuery<User> query = session.createSelectionQuery("from User", User.class);
		List<User> userList = query.getResultList();
		
		return userList;
	}

	@Override
	public HashMap<String, String> login(User user) {
		Session session = entityManager.unwrap(Session.class);
		
		SelectionQuery<User> query = session.createSelectionQuery("from User where username=:p", User.class);
		query.setParameter("p", user.getUsername());
		List<User> userList = query.getResultList();
		if(userList.size() == 0) throw new InvalidParameterException("Invalid credentials");
		
		BasicPasswordEncryptor passwordEnc = new BasicPasswordEncryptor();
		String password = user.getPassword();
		HashMap<String, String> response = new HashMap<>();
		if(passwordEnc.checkPassword(password, userList.get(0).getPassword())) {
				response.put("success", "true");
				response.put("id", String.valueOf(userList.get(0).getId()));
				response.put("email", userList.get(0).getEmail());
				response.put("username", userList.get(0).getUsername());
				response.put("role", String.valueOf(userList.get(0).getRole()));
				
				return response;
		}
		else {
			 throw new InvalidParameterException("Invalid credentials");
		}
	}

	@Override
	public HashMap<String, String> deleteUser(User user, int id) {
		Session session = entityManager.unwrap(Session.class);
		
		user.setId(id);
		
		User userFromDB = session.get(User.class, id);
		HashMap<String,String> response = login(user);
		if(response.get("success").equals("true")) {
			session.remove(userFromDB);
			return response;
		}
		else {
			throw new InvalidParameterException("Invalid credentials");
		}
	}

	@Override
	public HashMap<String, String> editUser(User user, int id) {
		Session session = entityManager.unwrap(Session.class);
		
		User userFromDB = session.get(User.class, id);
		user.setId(id);
		if(login(user).get("success").equals("true")) {
			userFromDB.setEmail(user.getEmail());
			HashMap<String, String> response = new HashMap<>();
			response.put("success", "true");
			return response;
		}
		else
			throw new InvalidParameterException("Invalid credentials");
	}

}

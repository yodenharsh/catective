package ai.petthinq.catectivesbackend.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.petthinq.catectivesbackend.dao.UserDAO;
import ai.petthinq.catectivesbackend.entity.User;
import ai.petthinq.catectivesbackend.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public int save(User user) {
		return userDAO.save(user);
	}
	
	@Override
	@Transactional
	public User findById(int id) {
		User user = userDAO.findById(id);
		
		if(user == null) throw new EntityNotFoundException("User with id="+id+"was not found");
		return user;
	}
	
	@Override
	@Transactional
	public HashMap<String, String> login(User user) {
		return userDAO.login(user);
	}

	@Override
	@Transactional
	public HashMap<String, String> deleteUser(User user, int id) {
		return userDAO.deleteUser(user, id);
	}

	@Override
	@Transactional
	public HashMap<String, String> editUser(User user, int id) {
		return userDAO.editUser(user, id);
	}

}

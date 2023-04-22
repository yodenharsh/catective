package ai.petthinq.catectivesbackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import ai.petthinq.catectivesbackend.dao.UserCatDAO;
import ai.petthinq.catectivesbackend.entity.User;
import ai.petthinq.catectivesbackend.entity.UserCat;
import jakarta.persistence.EntityManager;

@Repository
public class UserCatDAOImpl implements UserCatDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public UserCatDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public UserCat findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.find(UserCat.class, id);
	}
	
	public List<UserCat> findByUserId(int userId){
		Session session = entityManager.unwrap(Session.class);
		
		User user = session.get(User.class, userId);
		if(user == null) return null;
		
		SelectionQuery<UserCat> query = session.createSelectionQuery("from UserCat where user=:p", UserCat.class);
		List<UserCat> userCatList =  query.setParameter("p", user).getResultList();
		return userCatList;
	}

	@Override
	public List<UserCat> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		SelectionQuery<UserCat> query = session.createSelectionQuery("from UserCat",UserCat.class);
		
		return query.getResultList();
	}

	@Override
	public UserCat editCat(UserCat userCat) {
		Session session = entityManager.unwrap(Session.class);
		
		UserCat userCatFromDB = session.get(UserCat.class, userCat.getId());
		
		if(userCatFromDB == null) return null;
		
		userCatFromDB.setName(userCat.getName());
		userCatFromDB.setAddress(userCat.getAddress());
		userCatFromDB.setxCoords(userCat.getxCoords());
		userCatFromDB.setyCoords(userCat.getyCoords());
		userCatFromDB.setDesc(userCat.getDesc());
		userCatFromDB.setDateLost(userCat.getDateLost());
		userCatFromDB.setFound(userCat.isFound());
		userCatFromDB.setNumberOfImages(userCat.getNumberOfImages());
		userCatFromDB.setNosePrintAvailable(userCat.isNosePrintAvailable());
		
		return userCatFromDB;
	}

	@Override
	public boolean deleteCatById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		UserCat userCat = session.find(UserCat.class, id);
		
		if(userCat == null) return false;
		
		session.remove(userCat);
		
		return true;
	}

	@Override
	public boolean addImage(int id, MultipartFile image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNosePrint(int id, MultipartFile image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllImage(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeNosePrint(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserCat(UserCat userCat) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(userCat);
		return true;

	}

}

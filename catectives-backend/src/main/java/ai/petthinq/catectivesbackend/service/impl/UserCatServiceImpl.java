package ai.petthinq.catectivesbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ai.petthinq.catectivesbackend.dao.UserCatDAO;
import ai.petthinq.catectivesbackend.dao.UserDAO;
import ai.petthinq.catectivesbackend.entity.User;
import ai.petthinq.catectivesbackend.entity.UserCat;
import ai.petthinq.catectivesbackend.service.UserCatService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserCatServiceImpl implements UserCatService {

	private UserCatDAO userCatDAO;
	private UserDAO userDAO;
	
	@Autowired
	public UserCatServiceImpl(UserCatDAO userCatDAO, UserDAO userDAO) {
		this.userCatDAO = userCatDAO;
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public UserCat findById(int id) {
		UserCat userCat = userCatDAO.findById(id);
		if(userCat == null) throw new EntityNotFoundException("Cat with id="+id+" was not found");
		return userCat;
	}

	@Override
	@Transactional
	public List<UserCat> findAll() {
		return userCatDAO.findAll();
	}
	
	@Override
	@Transactional
	public List<UserCat> findByUserId(int userId) {
		List<UserCat> userCats = userCatDAO.findByUserId(userId);
		if(userCats == null) throw new EntityNotFoundException("No user with userId="+userId +" was found");
		return userCats;
	}
	
	@Transactional
	@Override
	public boolean addUserCat(UserCat userCat, int userId) {
		try {
		User user = userDAO.findById(userId);
		userCat.setUser(user);
		userCatDAO.addUserCat(userCat);
		return true;
		} catch(EntityNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	@Transactional
	public UserCat editCat(UserCat userCat) {
		UserCat editUserCat = userCatDAO.editCat(userCat);
		if(editUserCat == null)
			throw new EntityNotFoundException();
		else
			return editUserCat;
	}

	@Override
	@Transactional
	public boolean deleteCatById(int id) {
		boolean isDeleted = userCatDAO.deleteCatById(id);
		return isDeleted;
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


}

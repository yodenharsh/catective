package ai.petthinq.catectivesbackend.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ai.petthinq.catectivesbackend.entity.UserCat;

public interface UserCatDAO {
	
	public UserCat findById(int id);
	
	public List<UserCat> findByUserId(int userId);
	
	public List<UserCat> findAll();
	
	public boolean addUserCat(UserCat userCat); 
	
	public UserCat editCat(UserCat userCat);
	
	public boolean deleteCatById(int id);
	
	public boolean addImage(int id, MultipartFile image);
	
	public boolean addNosePrint(int id, MultipartFile image);
	
	public boolean removeAllImage(int id);
	
	public boolean removeNosePrint(int id);
}

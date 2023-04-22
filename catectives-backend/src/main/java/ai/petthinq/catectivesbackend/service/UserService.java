package ai.petthinq.catectivesbackend.service;

import java.util.HashMap;
import java.util.List;

import ai.petthinq.catectivesbackend.entity.User;

public interface UserService {
	public List<User> findAll();
	
	public int save(User user);
	
	public User findById(int id);
	
	public HashMap<String, String> login(User user);
	
	public HashMap<String, String> deleteUser(User user, int id);
	
	public HashMap<String, String> editUser(User user, int id);
}

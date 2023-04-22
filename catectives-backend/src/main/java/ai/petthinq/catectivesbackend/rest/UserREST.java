package ai.petthinq.catectivesbackend.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.petthinq.catectivesbackend.entity.User;
import ai.petthinq.catectivesbackend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserREST {
	private UserService userService;

	@Autowired
	public UserREST(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/user")
	public HashMap<String, Integer> addUser(@RequestBody User user){
		int userId = userService.save(user);
		
		HashMap<String, Integer> response = new HashMap<>();
		response.put("id", userId);
		return response;
	}
	
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<HashMap<String, String>> login(@RequestBody User user){
		HashMap<String, String> response = userService.login(user);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HashMap<String,String>> deleteUser(@RequestBody User user, @PathVariable int id){
		HashMap<String, String> response = userService.deleteUser(user, id);
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> editUser(@RequestBody User user, @PathVariable int id){
		HashMap<String, String> response = userService.editUser(user, id);
		
		return ResponseEntity.ok(response);
	}
	
}

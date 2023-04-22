package ai.petthinq.catectivesbackend.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.petthinq.catectivesbackend.entity.UserCat;
import ai.petthinq.catectivesbackend.service.UserCatService;

@RestController
@RequestMapping("/api")
public class UserCatREST {

	private UserCatService userCatService;
	
	@Autowired
	public UserCatREST(UserCatService userCatService) {
		this.userCatService = userCatService;
	}
	
	@GetMapping("/user-cat")
	public List<UserCat> getAll(){
		return userCatService.findAll();
	}
	
	@PostMapping("/user-cat/{userId}")
	public ResponseEntity<HashMap<String, String>> addUserCat(@RequestBody UserCat userCat, @PathVariable int userId){
		boolean added = userCatService.addUserCat(userCat, userId);
		HashMap<String, String> response = new HashMap<>();
		response.put("success", String.valueOf(added));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user-cat/user/{userId}")
	public List<UserCat> getByUserId(@PathVariable int userId){
		return userCatService.findByUserId(userId);
	}
	
	@PatchMapping("/user-cat")
	public UserCat editUserCat(@RequestBody UserCat userCat) {
		return userCatService.editCat(userCat);
	}
	
	@DeleteMapping("/user-cat/{userCatId}")
	public ResponseEntity<HashMap<String, String>> deleteCat(@PathVariable int userCatId){
		boolean deleted = userCatService.deleteCatById(userCatId);
		
		HashMap<String, String> response = new HashMap<>();
		response.put("success", String.valueOf(deleted));
		
		return ResponseEntity.ok(response);
	}
}

package ai.petthinq.catectivesbackend.entity;

import ai.petthinq.catectivesbackend.util.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "user-table")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "role")
    @Enumerated(EnumType.STRING)
	private Roles role;

	public User(int id, @Email String email, String password, String username, Roles role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
	}

	public User(@Email String email, String password, String username, Roles role) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	

	public User(@Email String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public User(String password, String username) {
		this.password = password;
		this.username = username;
	}
	
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	
}

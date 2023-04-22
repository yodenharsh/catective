package ai.petthinq.catectivesbackend.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user-cat")
public class UserCat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "`name`")
	private String name;

	@Nullable
	@Column(name = "address")
	private String address;

	@Column(name = "x-coords")
	@Nullable
	private float xCoords;

	@Column(name = "y-coords")
	@Nullable
	private float yCoords;	

	@Nullable
	@Column(name = "`desc`")
	private String desc;

	@Nullable
	@Column(name = "date-lost")
	private LocalDate dateLost;

	@Column(name = "is-found")
	private boolean isFound;

	@Column(name = "nose-print-available")
	private boolean nosePrintAvailable;

	@Column(name = "number-of-images")
	private int numberOfImages;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			 })
	@JsonIgnore
	@JoinColumn(name = "user-id")
	@NotNull
	private User user;

	public UserCat(int id, String name, String address, float xCoords, float yCoords, String desc, LocalDate dateLost,
			boolean isFound, boolean nosePrintAvailable, int numberOfImages, @NotNull User user) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.desc = desc;
		this.dateLost = dateLost;
		this.isFound = isFound;
		this.nosePrintAvailable = nosePrintAvailable;
		this.numberOfImages = numberOfImages;
		this.user = user;
	}

	public UserCat(String name, String address, float xCoords, float yCoords, String desc, LocalDate dateLost,
			boolean isFound, boolean nosePrintAvailable, int numberOfImages, @NotNull User user) {
		this.name = name;
		this.address = address;
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.desc = desc;
		this.dateLost = dateLost;
		this.isFound = isFound;
		this.nosePrintAvailable = nosePrintAvailable;
		this.numberOfImages = numberOfImages;
		this.user = user;
	}
	

	public UserCat(String name, String address, float xCoords, float yCoords, String desc, LocalDate dateLost,
			boolean isFound, boolean nosePrintAvailable, int numberOfImages) {
		this.name = name;
		this.address = address;
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.desc = desc;
		this.dateLost = dateLost;
		this.isFound = isFound;
		this.nosePrintAvailable = nosePrintAvailable;
		this.numberOfImages = numberOfImages;
	}

	public UserCat() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getxCoords() {
		return xCoords;
	}

	public void setxCoords(float xCoords) {
		this.xCoords = xCoords;
	}

	public float getyCoords() {
		return yCoords;
	}

	public void setyCoords(float yCoords) {
		this.yCoords = yCoords;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getDateLost() {
		return dateLost;
	}

	public void setDateLost(LocalDate dateLost) {
		this.dateLost = dateLost;
	}
	
	@JsonProperty("isFound")
	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	public boolean isNosePrintAvailable() {
		return nosePrintAvailable;
	}

	public void setNosePrintAvailable(boolean nosePrintAvailable) {
		this.nosePrintAvailable = nosePrintAvailable;
	}

	public int getNumberOfImages() {
		return numberOfImages;
	}

	public void setNumberOfImages(int numberOfImages) {
		this.numberOfImages = numberOfImages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserCat [name=" + name + ", address=" + address + ", xCoords=" + xCoords + ", yCoords=" + yCoords
				+ ", desc=" + desc + ", dateLost=" + dateLost + ", isFound=" + isFound + ", nosePrintAvailable="
				+ nosePrintAvailable + ", numberOfImages=" + numberOfImages + ", userId="+user.getId()+ "]";
	}
	
	

}

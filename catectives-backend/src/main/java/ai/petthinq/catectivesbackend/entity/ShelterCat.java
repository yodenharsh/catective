package ai.petthinq.catectivesbackend.entity;

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
@Table(name = "shelter-cat")
public class ShelterCat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Nullable
	@Column(name = "name")
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

	@Column(name = "nose-print-available")
	private boolean nosePrintAvailable;

	@Column(name = "number-of-images")
	private int numberOfImages;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.REMOVE })
	@JoinColumn(name = "user-id")
	@NotNull
	private User user;

	public ShelterCat(int id, String name, String address, float xCoords, float yCoords, boolean nosePrintAvailable,
			int numberOfImages, @NotNull User user) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.nosePrintAvailable = nosePrintAvailable;
		this.numberOfImages = numberOfImages;
		this.user = user;
	}

	public ShelterCat(String name, String address, float xCoords, float yCoords, boolean nosePrintAvailable,
			int numberOfImages, @NotNull User user) {
		this.name = name;
		this.address = address;
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.nosePrintAvailable = nosePrintAvailable;
		this.numberOfImages = numberOfImages;
		this.user = user;
	}

	public ShelterCat() {
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

}

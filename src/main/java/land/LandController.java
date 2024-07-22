package land;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LandController {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(nullable = false, unique = true)
	private String landName;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String town;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false)
	private int area;
	
	public LandController() {}
	
	public long getId() {
		return Id;
	}
	
	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public String getLandName() {
		return landName;
	}
	
	public void setLandName(String landName) {
		this.landName = landName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getNeighborhoodString() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
}

package land;

public class ShowRequest {

	private String landName;
	private String city;
	private String town;
	private String neighborhood;
	private int area;
	
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
	
	public String getNeighborhood() {
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
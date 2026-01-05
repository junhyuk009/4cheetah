package model.dto;

public class PlaceDTO {
	private int id;
	private String name;
	private String address;
	private double lat;
	private double lng;

	public PlaceDTO() {
	}

	public PlaceDTO(int id, String name, String address, double lat, double lng) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
}

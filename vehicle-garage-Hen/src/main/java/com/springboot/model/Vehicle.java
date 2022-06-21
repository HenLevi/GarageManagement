package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public  class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;


	@Column(name = "type")
	private String type;

	@Column(name = "vehicle_license")
	private String vehicleLicense;

	@Column(name = "description")
	private String description;

	@Column(name = "year_manufacturing")
	private int yearManufacturing;

	@Column(name = "status")
	private String status;

	@Column(name = "price")
	private int price;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicleLicense() {
		return vehicleLicense;
	}

	public void setVehicleLicense(String vehicleLicense) {
		this.vehicleLicense = vehicleLicense;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearManufacturing() {
		return yearManufacturing;
	}

	public void setYearManufacturing(int yearManufacturing) {
		this.yearManufacturing = yearManufacturing;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vehicle(){
		
	}
	
	
	public Vehicle(Integer id, String type, String vehicleLicense, String description, int yearManufacturing,
			String status, int price) {
		super();
		this.id = id;
		this.type = type;
		this.vehicleLicense = vehicleLicense;
		this.description = description;
		this.yearManufacturing = yearManufacturing;
		this.status = status;
		this.price = price;
	}


}

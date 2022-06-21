package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle {

	@Column(name = "extra_sit")
	private boolean extraSit;

	public boolean isExtraSit() {
		return extraSit;
	}

	public void setExtraSit(boolean extraSit) {
		this.extraSit = extraSit;
	}

	public Motorcycle(Integer id, String type, String vehicleLicense, String description, int yearManufacturing,
			String status, int price, boolean extraSit) {
		super(id, type, vehicleLicense, description, yearManufacturing, status, price);
		this.extraSit = extraSit;
	}

}

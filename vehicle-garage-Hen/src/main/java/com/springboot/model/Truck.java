package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck extends Vehicle {

	@Column(name = "weight_limit")
	private int weightLimit;

	public int getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(int weightLimit) {
		this.weightLimit = weightLimit;
	}

	public Truck(Integer id, String type, String vehicleLicense, String description, int yearManufacturing,
			String status, int price, Integer id2, int weightLimit) {
		super(id, type, vehicleLicense, description, yearManufacturing, status, price);
		id = id2;
		this.weightLimit = weightLimit;
	}

}

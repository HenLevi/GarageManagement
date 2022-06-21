package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends Vehicle {
	public Car() {

	}

	public Car(Integer id, String type, String vehicleLicense, String description, int yearManufacturing, String status,
			int price) {
		super(id, type, vehicleLicense, description, yearManufacturing, status, price);
	}

}

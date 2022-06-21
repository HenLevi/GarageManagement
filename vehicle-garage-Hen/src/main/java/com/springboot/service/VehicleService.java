package com.springboot.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.dao.CarDao;
import com.springboot.dao.MotorcycleDao;
import com.springboot.dao.TruckDao;
import com.springboot.dao.VehicleDao;
import com.springboot.model.Car;
import com.springboot.model.Motorcycle;
import com.springboot.model.Truck;

@Service
public class VehicleService {
	@Autowired
	VehicleDao vehicleDao;
	@Autowired
	CarDao carDao;
	@Autowired
	MotorcycleDao motorcycleDao;
	@Autowired
	TruckDao truckDao;

	// (1)
	public void addTruck(Truck truck) {
		truckDao.save(truck);
	}

	public void addCar(Car car) {
		carDao.save(car);
	}

	public void addMotorcycle(Motorcycle motocycle) {
		motorcycleDao.save(motocycle);
	}

	// (2)

	public Car findCarAndChangeStatus(String getVehicleLicense) {

		List<Car> vehiclesList = (List<Car>) carDao.findAll();

		Car carFiltered = vehiclesList.stream().filter(c -> c.getVehicleLicense().equals(getVehicleLicense)).findAny()
				.orElse(null);

		carFiltered.setStatus("In Process"); // if i get him status, he will not get release status. I will write in
												// util the function of delete
		return carFiltered;

	}

	// (3)
	public Optional<Car> showVehicleDetails(String vehicleLicense) {
		List<Car> vehiclesList = (List<Car>) carDao.findAll();
		Optional<Car> vehicleDetails = vehiclesList.stream()
				.filter(vehicle -> vehicle.getVehicleLicense().equals(vehicleLicense)).findAny();
		return vehicleDetails;
	}

	// (4)
	public List<Car> showVehiclesListByStatus() {
		List<Car> vehiclesList = (List<Car>) carDao.findAll();
		List<Car> vehiclesByStatus = vehiclesList.stream().filter(status -> !status.getStatus().equals("Released"))
				.collect(Collectors.toList());
		return vehiclesByStatus;
	}

	// (5)
	public List<Car> showVehiclesListByKeyword(String description) {
		List<Car> vehiclesList = (List<Car>) carDao.findAll();
		List<Car> vehiclesSorted = vehiclesList.stream().filter(x -> x.getDescription().contains(description))
				.collect(Collectors.toList());
		return vehiclesSorted;

	}

	// (6)
	public List<Car> getVehiclesByYearManufacturing(int yearManufacturing) {
		List<Car> vehiclesList = (List<Car>) carDao.findAll();
		List<Car> vehiclesSorted = vehiclesList.stream().sorted(Comparator.comparingInt(Car::getYearManufacturing))
				.collect(Collectors.toList());
		return vehiclesSorted;
	}

	// (7)
	public void totalProfit() {
		List<Car> vehiclesList = (List<Car>) carDao.findAll();
		int totalProfit = vehiclesList.stream().filter(status -> status.getStatus().equals("Released"))
				.mapToInt(s -> s.getPrice()).sum();
		System.out.println("Total Profit: " + totalProfit);
	}

}

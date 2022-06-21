package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Car;
import com.springboot.model.Motorcycle;
import com.springboot.model.Truck;
import com.springboot.model.Vehicle;
import com.springboot.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	VehicleService vehicleService;

	// (1)

	@PostMapping(value = "/addCar", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public void addCar(@RequestBody Car car) {
		try {
			car.setStatus("New");
			if (car.getType().equals("Car")) {
				vehicleService.addCar(car);
			}
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in addCar function, exception: " + e);
		}
	}

	@PostMapping(value = "/addMotorcycle", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public void addMotorcycle(@RequestBody Motorcycle motocycle) {
		try {
			motocycle.setStatus("New");

			if (motocycle.getType().equals("Motocycle")) {
				vehicleService.addMotorcycle(motocycle);
			}
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in addMotorcycle function, exception: " + e);
		}
	}

	@PostMapping(value = "/addTruck", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public void addTruck(@RequestBody Truck truck) {
		try {
			truck.setStatus("New");
			if (truck.getType().equals("Truck")) {
				vehicleService.addTruck(truck);
			}
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in addTruck function, exception: " + e);
		}
	}

	// (2)
	@PutMapping("/changeVehicleStatus")
	public ResponseEntity<Car> changeCarStatus(@RequestParam String vehicleLicense) {
		try {
			Car carFiltered = vehicleService.findCarAndChangeStatus(vehicleLicense);

			return new ResponseEntity<Car>(carFiltered, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in changeCarStatus function, exception: " + e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// (3)
	@GetMapping(value = "/showVehicleDetails")
	public ResponseEntity<Optional<Car>> showVehicleDetails(@RequestParam String vehicleLicense) {
		try {
			Optional<Car> vehicleFilteredByLicenseNumber = vehicleService.showVehicleDetails(vehicleLicense);
			return new ResponseEntity<Optional<Car>>(vehicleFilteredByLicenseNumber, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in showVehicleDetails function, exception: " + e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// (4)
	@GetMapping(value = "/showVehiclesListByStatus")
	public ResponseEntity<List<Car>> showVehiclesListByStatus() {
		try {
			List<Car> vehicleFilteredByStatus = vehicleService.showVehiclesListByStatus();
			return new ResponseEntity<List<Car>>(vehicleFilteredByStatus, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in showVehiclesListByStatus function, exception: " + e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// (5)
	@GetMapping("/showVehiclesListByKeyword")
	@ResponseBody
	public ResponseEntity<List<Car>> showVehiclesListByKeyword(@RequestParam String description) {
		try {
			List<Car> vehicleFilteredByByKeyword = vehicleService.showVehiclesListByKeyword(description);
			return new ResponseEntity<List<Car>>(vehicleFilteredByByKeyword, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in showVehiclesListByKeyword function, exception: " + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// (6)
	@GetMapping("/yearManufacturing")
	@ResponseBody
	public ResponseEntity<List<Car>> getVehiclesByYearManufacturing(@RequestParam int yearManufacturing) {
		try {
			List<Car> vehicleFilteredByYearManufacturing = (List<Car>) vehicleService
					.getVehiclesByYearManufacturing(yearManufacturing);
			return new ResponseEntity<List<Car>>(vehicleFilteredByYearManufacturing, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in getVehiclesByYearManufacturing function, exception: "
					+ e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// (7)
	@GetMapping("/totalProfit")
	public void totalProfit() {
		try {
			vehicleService.totalProfit();
		} catch (Exception e) {
			LOG.error("Error in controller: VehicleController in totalProfit function, exception: " + e);
		}
	}

}

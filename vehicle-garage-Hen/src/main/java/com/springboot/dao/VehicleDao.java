package com.springboot.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.Vehicle;

@Repository
@Primary
public interface VehicleDao extends CrudRepository<Vehicle, Integer> {

}

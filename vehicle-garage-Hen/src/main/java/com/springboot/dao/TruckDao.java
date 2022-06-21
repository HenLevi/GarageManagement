package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.Truck;

@Repository
public interface TruckDao extends CrudRepository<Truck, Integer> {

}
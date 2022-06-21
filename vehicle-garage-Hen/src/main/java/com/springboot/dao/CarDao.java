package com.springboot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.Car;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {


}
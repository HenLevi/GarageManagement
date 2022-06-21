package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.Motorcycle;

@Repository
public interface MotorcycleDao extends CrudRepository<Motorcycle, Integer> {

}
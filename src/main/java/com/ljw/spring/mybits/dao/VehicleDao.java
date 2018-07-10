package com.ljw.spring.mybits.dao;

import java.util.List;

import com.ljw.spring.mybits.annotation.MyBatisRepository;
import com.ljw.spring.mybits.dao.entity.Vehicle;


@MyBatisRepository
public interface VehicleDao {

	List<Vehicle> findAll();
	
	
	
}

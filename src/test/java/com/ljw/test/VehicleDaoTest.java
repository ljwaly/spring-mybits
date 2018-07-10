package com.ljw.test;

import java.util.List;

import org.junit.Test;

import com.ljw.spring.mybits.dao.VehicleDao;
import com.ljw.spring.mybits.dao.entity.Vehicle;

public class VehicleDaoTest extends FatherBean{
	
	@Test
	public void testFindAll(){
		VehicleDao vehicleDao = appMvc.getBean(VehicleDao.class);
		
		
		List<Vehicle> findAll = vehicleDao.findAll();
		for (Vehicle vehicle : findAll) {
			System.out.println(vehicle.getType());
			System.out.println(vehicle);
		}
		
	}
}

package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Vehicle;

public interface VehicleDao {
	void addVehicle(Vehicle v);
	List<String> getRegNos();
}

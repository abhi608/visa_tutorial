package com.visa.prj.dao;

import com.visa.prj.entity.Rental;

import java.util.List;

import com.visa.prj.dto.RentalReportDTO;


public interface RentalDao {
	void addRental(Rental rental);
	List<RentalReportDTO> getReport();
}

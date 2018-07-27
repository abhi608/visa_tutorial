package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Customer;

public interface CustomerDao {
	Customer getCustomer(String email) throws DaoException;
}

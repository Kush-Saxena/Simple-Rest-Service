package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.repository.IEmployeeDao;
import com.emp.util.ModelToJson;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao repo;

	@Autowired
	ModelToJson jsonUtil; // This utility converts data to json type.
	// This is just a case specific json converter and not a generic model
	// generation system.
	// For generic converter, use Jackson Object Mapper

	public String getAllEmployeeData() {
		return jsonUtil.convertToJson(repo.getAllEmployeeData());
	}

	public String getEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		return jsonUtil.convertToJson(repo.getEmployeeByName(employeeName));
	}

	public String getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return jsonUtil.convertToJson(repo.getEmployeeById(employeeId));
	}

}

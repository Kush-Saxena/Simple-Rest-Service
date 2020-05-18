package com.emp.repository;

import java.util.List;

import com.emp.model.EmployeeModel;

public interface IEmployeeDao {

	List<EmployeeModel> getAllEmployeeData();

	List<EmployeeModel> getEmployeeByName(String employeeName);

	EmployeeModel getEmployeeById(int employeeId);

}

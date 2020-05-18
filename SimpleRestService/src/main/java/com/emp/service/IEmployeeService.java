package com.emp.service;

public interface IEmployeeService {


	String getAllEmployeeData();

	String getEmployeeByName(String employeeName);

	String getEmployeeById(int employeeId);
	
	//All data is converted to Json string in the service layer and presented to the controller.
	
}

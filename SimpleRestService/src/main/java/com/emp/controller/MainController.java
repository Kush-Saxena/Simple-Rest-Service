package com.emp.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.emp.service.IEmployeeService;

@RestController
public class MainController {

	@Autowired
	IEmployeeService service;

	@RequestMapping(path = "getAll", produces = "application/json")
	public String getAllData() {

		return service.getAllEmployeeData();

	}

	@RequestMapping(path = "getbyid/{empid}", produces = "application/json")
	public String getByName(@PathVariable int empid) {

		return service.getEmployeeById(empid);

	}

	@RequestMapping(path = "getbyname/{empname}", produces = "application/json")
	public String getById(@PathVariable String empname) {

		return service.getEmployeeByName(empname);

	}

}

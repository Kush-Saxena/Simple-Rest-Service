package com.emp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<EmployeeModel> getAllEmployeeData() {
		String sql = "SELECT * FROM employeedb";
		List<EmployeeModel> drugList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<EmployeeModel>(EmployeeModel.class));
		return drugList;
	}

	public List<EmployeeModel> getEmployeeByName(String employeeName) {
		String sql = "Select * from employeedb where employeename like  \"%" + employeeName + "%\"";
		List<EmployeeModel> filteredList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<EmployeeModel>(EmployeeModel.class));

		return filteredList;
	}

	public EmployeeModel getEmployeeById(int employeeId) {
		String sql = "SELECT * FROM employeedb WHERE employeeid = ?";
		EmployeeModel emp = jdbcTemplate.queryForObject(sql, new Object[] { employeeId },
				new BeanPropertyRowMapper<EmployeeModel>(EmployeeModel.class));
		return emp;
	}

}

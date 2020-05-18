package com.emp.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emp.model.EmployeeModel;
//This is just a case specific json converter and not a generic model generation system.
//For generic converter, use Jackson Object Mapper

@Component
public class ModelToJson {

	public String convertToJson(EmployeeModel m) {
		return objToString(m);
	}

	public String convertToJson(List<EmployeeModel> m) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"EmployeeModel\":");
		sb.append("[");
		for (EmployeeModel emp : m) {
			sb.append(objToString(emp));
			sb.append(",");

		}
		sb.append("]");

		sb.append("}");

		return sb.toString();
	}

	private String objToString(EmployeeModel m) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");// Starting brace
		sb.append("\"employeeid\":" + m.getEmployeeid() + ",");
		sb.append("\"employeename\":" + "\"" + m.getEmployeename() + "\"");
		sb.append("}");// End brace

		return sb.toString();
	}

}

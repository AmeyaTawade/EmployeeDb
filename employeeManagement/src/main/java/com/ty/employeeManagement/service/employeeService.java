package com.ty.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.ty.employeeManagement.dto.employeeDto;
import com.ty.employeeManagement.model.employeeModel;

public interface employeeService {

	void saveEmployee(employeeDto emp);
	List<employeeModel> getAllEmployee();
	employeeModel getEmployeeById(int id);
	int changeFirstName(String firstName, int id);
	int changeLastName(int id, String lastName);
	int changeEmail(int id, String email);
	int deleteEmployee(int id);
	
}

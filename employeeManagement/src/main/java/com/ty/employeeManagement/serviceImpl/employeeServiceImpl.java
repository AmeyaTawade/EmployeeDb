package com.ty.employeeManagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeManagement.dto.employeeDto;
import com.ty.employeeManagement.model.employeeModel;
import com.ty.employeeManagement.repository.employeeRepository;
import com.ty.employeeManagement.service.employeeService;

@Service
public class employeeServiceImpl implements employeeService {

	@Autowired
	private employeeRepository empRepository;

	@Override
	public void saveEmployee(employeeDto emp) {
		empRepository.saveEmployee(emp);
	}

	@Override
	public List<employeeModel> getAllEmployee() {
		return empRepository.getAllEmployee();
	}

	@Override
	public employeeModel  getEmployeeById(int id) {
		return empRepository.getEmployeeById(id);
	}

	@Override
	public int changeFirstName(String firstName, int id) { 
		return empRepository.changeFirstName(firstName, id);
	}

	@Override
	public int changeLastName(int id, String lastName) {
		return empRepository.changeLastName(id, lastName);
	}

	@Override
	public int changeEmail(int id, String email) {
		return empRepository.changeEmail(id, email);
	}

	@Override
	public int deleteEmployee(int id) {
		return empRepository.deleteEmployee(id);
	}

}

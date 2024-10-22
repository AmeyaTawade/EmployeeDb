package com.ty.employeeManagement.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.ty.employeeManagement.dto.employeeDto;
import com.ty.employeeManagement.exception.employeeNotFoundException;
import com.ty.employeeManagement.model.employeeModel;
import com.ty.employeeManagement.model.rowmapper.employeeRowmapper;
import com.ty.employeeManagement.repository.employeeRepository;

@Repository
public class employeeRepositoryImpl implements employeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveEmployee(employeeDto emp) {
		String sql = "INSERT INTO employee_db (firstName, lastName, email) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getEmail());

	}

	@Override
	public List<employeeModel> getAllEmployee() {
		String sql = "SELECT * FROM employee_db";
		return jdbcTemplate.query(sql, new employeeRowmapper());
	}

	@Override
	public employeeModel getEmployeeById(int id) {
		String sql = "SELECT * FROM employee_db WHERE id =?";
		return jdbcTemplate.queryForObject(sql, new employeeRowmapper(), id);
	}

	@Override
	public int changeFirstName(String firstName, int id) {
		String sql = "UPDATE employee_db SET firstName = ? WHERE id = ?";
		return jdbcTemplate.update(sql, firstName, id);
	}

	@Override
	public int changeLastName(int id, String lastName) {
		String sql = "UPDATE employee_db SET lastName = ? WHERE id = ?";
		return jdbcTemplate.update(sql, lastName, id);
	}

	@Override
	public int changeEmail(int id, String email) {
		String sql = "UPDATE employee_db SET email = ? WHERE id = ?";
		return jdbcTemplate.update(sql, email, id);
	}

	@Override
	public int  deleteEmployee(int id) {
		String sql = "DELETE FROM employee_db WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}

}

package com.ty.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.employeeManagement.dto.employeeDto;

import com.ty.employeeManagement.model.employeeModel;
import com.ty.employeeManagement.service.employeeService;

@RestController
@RequestMapping("/api")
public class employeeController {

	@Autowired
	private employeeService empService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody employeeDto emp) {
		try {
			empService.saveEmployee(emp);
			return ResponseEntity.ok("Accoount has been created");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@GetMapping("/employees")
	public List<employeeModel> fetchAllEmployeeData() {
		try {
			return empService.getAllEmployee();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@GetMapping("/employees/{id}")
	public employeeModel fetchEmployeeById(@PathVariable int id) {
		try {
			return empService.getEmployeeById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@PutMapping("/changefirstname")
	public ResponseEntity<String> changeFirstNameById(@RequestParam String name, @RequestParam int id) {
		try {
			int rowsAffected = empService.changeFirstName(name, id);
			if (rowsAffected > 0) {
				return ResponseEntity.ok("First name changed successfully");
			} else {
				return ResponseEntity.badRequest().body("Employee with id " + id + " does not exist");
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@PutMapping("/changelastname")
	public ResponseEntity<String> changeLastNameById(@RequestParam int id, @RequestParam String name) {
		try {
			int rowsAffected = empService.changeLastName(id, name);
			if (rowsAffected > 0) {
				return ResponseEntity.ok("Last name changed successfully");
			} else {
				return ResponseEntity.badRequest().body("Employee with id " + id + " does not exist");
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@PutMapping("changeemail")
	public ResponseEntity<String> changeEmailById(@RequestParam int id,@RequestParam String email) {
		try {
			int rowsAffected = empService.changeEmail(id, email);
			if (rowsAffected > 0) {
				return ResponseEntity.ok("email changed successfully");
			} else {
				return ResponseEntity.badRequest().body("Employee with id " + id + "does not exist");
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		try {
			int rowsAffected = empService.deleteEmployee(id);
			if (rowsAffected > 0) {
				return ResponseEntity.ok("your account has been deleted");
			} else {
				return ResponseEntity.badRequest().body("Employee with id " + id + "does not exist");
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}

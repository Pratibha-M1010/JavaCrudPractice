package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
//	If the methods are not working in Swagger Try PostMan 
	
	@Autowired
	private EmployeeService empService;

	@PostMapping("/add")
	public Employee addEmployeeDetails(@RequestBody Employee emp) {
		return empService.addEmployeeDetails(emp);
	}
	
	@GetMapping("/getemployee")
	public Employee getEmployeeDetais(@RequestParam String email,@RequestParam String password) {
		System.out.println(email+"  "+password);
		return empService.getEmployeeDetails(email,password);
	}
	
	@PutMapping("/updateemployee")
	public Employee updateEmployeeDetails(@RequestBody Employee emp) {
//		Give Employee Id of the employee to update
		return empService.updateEmployeeDetails(emp);
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		return empService.deleteEmployeeDetails(id);
	}
	
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return empService.getEmployeeById(id);
	}
}

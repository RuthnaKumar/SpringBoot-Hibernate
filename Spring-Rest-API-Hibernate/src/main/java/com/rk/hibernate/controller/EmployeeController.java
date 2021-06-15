package com.rk.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.hibernate.model.Employee;
import com.rk.hibernate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeeService.get();
	}
	
	//SAVE THE DATA TO DATABASE
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}
	
	//FETCH SINGLE DATA FROM DATABASE
	@GetMapping("/employee/{id}")
	public Employee grt(@PathVariable int id) {
		Employee employeeObj =  employeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee with id : "+id+ " is not found");
		}
		return employeeObj;
	}
	
	//DELETE DATA FROM DATABASE
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return"Employee has Deleted with id :" +id;
	}
	
	//UPDATE THE DATABASE DATA
	@PutMapping("/employee/{id}")
	public Employee update(@PathVariable ("id") int id,@RequestBody Employee employeeObj) {
		employeeObj.setId(id);
		employeeService.save(employeeObj);
		return employeeObj;
	}
}

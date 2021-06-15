package com.rk.hibernate.service;

import java.util.List;

import com.rk.hibernate.model.Employee;

public interface EmployeeService {

	    //FETCH ALL DATA FROM DATABASE
		List<Employee> get();
		//FETCH SINGLE DATA FROM DATABASE
		Employee get(int id);
		//SAVE DATA TO DATABASE
		void save(Employee employee);
		//DEIETE DATA FROM DATABASE
		void delete(int id);
		//UPDATE DATE IN DATABASE
		void update(Employee employee);
}

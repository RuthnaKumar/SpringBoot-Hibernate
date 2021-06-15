package com.rk.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.hibernate.dao.EmployeeDAO;
import com.rk.hibernate.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	//READ DATA FROM DATABASE
	@Transactional
	@Override
	public List<Employee> get() {
		return employeeDAO.get();
	}

	//FETCH SINGLE DATA FROM DATABASE
	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		
	}

	//DELETE DATA FROM DATABASE
	@Transactional
	@Override
	public void delete(int id) {
	employeeDAO.delete(id);
		
	}

	//UPDATE DATA IN DATABASE
	@Transactional
	@Override
	public void update(Employee employee) {
		employeeDAO.save(employee);
		
	}
}

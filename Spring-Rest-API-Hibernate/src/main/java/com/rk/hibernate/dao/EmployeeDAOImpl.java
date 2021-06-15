package com.rk.hibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import com.rk.hibernate.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	//FETCH THE DATA FORM DATABASE
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	//FETCH SINGLE DATA FROM DATABASE
	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class,id);
		return employeeObj;
	}

	//SAVE DATA TO DATABASE
	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	//DELETE DATA IN DATABASE
	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class,id);
		currentSession.delete(employeeObj);
		
	}

	//UPDATE DATA IN DATABASE
	@Override
	public void update(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employee);
	}
}

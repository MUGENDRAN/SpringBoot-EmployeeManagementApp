package edu.jspiders.employeeapp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.employeeapp.dao.EmployeeDao;
import edu.jspiders.employeeapp.dto.Employee;
import edu.jspiders.employeeapp.responsestructure.ResponseStructure;


@Service
public class EmployeeServiceImp implements EmployeeService
{
	
	@Autowired
	EmployeeDao dao;

	@Override
	public ResponseStructure<Employee> registerEmp(Employee employee) 
	{
		Employee employee2 = dao.saveEmployee(employee);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		structure.setData(employee2);
		structure.setDateTime(LocalDateTime.now());
		structure.setStatusCode(200);
		structure.setMessage("hello");
		return structure;
	}

	@Override
	public Optional<Employee> findEmp(int id) {
		Optional<Employee> optional = dao.findEmp(id);
		return optional;
		
	}

	@Override
	public String employeeLogIn(String employeeEmail, String employeePassword) 
	{
		String message = dao.empLogin(employeeEmail,employeePassword);
		return message;
	}
	
	@Override
	public Optional<Employee> findByContact(String employeePhoneNumber) {
		Optional<Employee> optional=dao.findByContact(employeePhoneNumber);
		return optional;
	}

	@Override
	public String deleteEmp(int id) {
		String optional = dao.deleteEmp(id);
		return optional;
	}

	public Optional<Employee> updateEmployee(Employee employee) {
		Optional<Employee> optional = dao.updateEmployee(employee);
		return optional;
	}

	
	

}

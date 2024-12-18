package edu.jspiders.employeeapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jspiders.employeeapp.dto.Employee;
import edu.jspiders.employeeapp.exceptionHandler.IdNotFoundException;
import edu.jspiders.employeeapp.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) 
	{
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
		
		
	}

	public Optional<Employee> findEmp(int id) 
	{
		Optional<Employee> optional = employeeRepository.findById(id);
		return optional;

		
	}

	public String empLogin(String employeeEmail, String employeePassword) 
	{
		Employee employee = employeeRepository.findByEmployeeEmail(employeeEmail);
		if(employee!=null) 
		{
			employee.getEmployeePassword().equals(employeePassword);
			return "Login Success...";
		}
		throw new IdNotFoundException("Credentials are incorrect");
	}

	public Optional<Employee> findByContact(String employeePhoneNumber) {

		Optional<Employee> optional = employeeRepository.findByEmployeePhoneNumber(employeePhoneNumber);
		return optional;
	}

	public String deleteEmp(int id) {
		employeeRepository.deleteById(id);
		return "Record is deleted...";
		
	}

	public Optional<Employee> updateEmployee(Employee employee) {
		Optional<Employee> optional= employeeRepository.findById(employee.getEmployeeId());
		if(optional.isPresent()) 
		{
			Employee employee1 = employeeRepository.save(employee);
			return optional;
		}
		else 
		{
			throw new IllegalArgumentException("Id doesn't exist...");
		}
	}

}

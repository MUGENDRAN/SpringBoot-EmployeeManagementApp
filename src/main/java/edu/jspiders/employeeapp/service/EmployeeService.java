package edu.jspiders.employeeapp.service;

import java.util.Optional;

import edu.jspiders.employeeapp.dto.Employee;
import edu.jspiders.employeeapp.responsestructure.ResponseStructure;

public interface EmployeeService 
{
	ResponseStructure<Employee> registerEmp(Employee employee);
	Optional<Employee>findEmp(int id);
	String employeeLogIn(String employeeEmail,String employeePassword);
	Optional<Employee> findByContact(String employeePhoneNumber);
	String deleteEmp(int id);
	

}

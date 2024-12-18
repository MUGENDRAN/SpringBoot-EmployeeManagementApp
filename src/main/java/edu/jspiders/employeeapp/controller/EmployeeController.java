package edu.jspiders.employeeapp.controller;

import java.util.List;
import java.util.Optional;

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

import edu.jspiders.employeeapp.dto.Employee;
import edu.jspiders.employeeapp.repository.EmployeeRepository;
import edu.jspiders.employeeapp.responsestructure.ResponseStructure;
import edu.jspiders.employeeapp.service.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeServiceImp serviceImp;
	@Autowired
	EmployeeRepository empRep;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) 
	{
//		Employee employee2=serviceImp.registerEmp(employee);
//		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		ResponseStructure<Employee> structure=serviceImp.registerEmp(employee);
		return new ResponseEntity<>(structure,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findEmp/{employeeId}")
	public Optional<Employee> findEmployee(@PathVariable int employeeId) 
	{
		Optional<Employee> emp=serviceImp.findEmp(employeeId);
		return emp;
	}
	
	@GetMapping("/findByContact/{employeePhoneNumber}")
	public Optional<Employee> findEmployee(@PathVariable String employeePhoneNumber) 
	{
		Optional<Employee> emp=serviceImp.findByContact(employeePhoneNumber);
		return emp;
	}
	
	@DeleteMapping("/deleteEmp/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) 
	{
		String emp=serviceImp.deleteEmp(employeeId);
		return emp;
	}
	
	@PutMapping("/updateEmployee")
	public Optional<Employee> updateEmployee(@RequestBody Employee employee) 
	{
		Optional<Employee> emp=serviceImp.updateEmployee(employee);
		return emp;


	}
	
	
	
	
	
	
	
	@GetMapping("/login")
	public String empLogin(@RequestParam String employeeEmail,@RequestParam String employeePassword) 
	{
		String message = serviceImp.employeeLogIn(employeeEmail, employeePassword);
		return message;
	}
	
	
	@GetMapping("/query")
	public ResponseEntity<?> findEmployeeName() 
	{
		List<String> name=empRep.getEmp();
		return new ResponseEntity<>(name,HttpStatus.ACCEPTED);
	}

}

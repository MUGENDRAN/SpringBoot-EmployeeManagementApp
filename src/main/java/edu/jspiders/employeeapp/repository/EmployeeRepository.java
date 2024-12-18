package edu.jspiders.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jspiders.employeeapp.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Employee findByEmployeeEmail(String employeeEmail);

	Optional<Employee> findByEmployeePhoneNumber(String employeePhoneNumber);

	@Query(value="select * from employee.employee",nativeQuery=true) 
	public List<String> getEmp();
}

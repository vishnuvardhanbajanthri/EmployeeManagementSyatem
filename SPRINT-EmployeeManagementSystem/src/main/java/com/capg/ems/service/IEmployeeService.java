package com.capg.ems.service;

import java.util.List;
import java.util.Optional;

import com.capg.ems.dto.EmployeeDTO;
import com.capg.ems.entities.Employee;
import com.capg.ems.exceptions.EmployeeNotFoundException;

/*Service Interface for Employee Management System
 * Author: Riyanka Ghosh
 * Date Created: 09/01/2022
 */

public interface IEmployeeService {

	public List<EmployeeDTO> getAllEmployees();
	
	public EmployeeDTO addEmployee(EmployeeDTO emp);

	public void deleteEmployee(int userId) throws EmployeeNotFoundException;

	public EmployeeDTO updateEmployee(EmployeeDTO emp);

	public Optional<Employee> getEmployeeById(int userid) throws EmployeeNotFoundException;

	public long getEmployeeCount();

}

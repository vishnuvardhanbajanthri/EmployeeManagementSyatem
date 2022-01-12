package com.capg.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.dto.EmployeeDTO;
import com.capg.ems.entities.Employee;
import com.capg.ems.exceptions.EmployeeNotFoundException;
import com.capg.ems.repositories.IEmployeeRepository;
/*
 * Author : Riyanka Ghosh
 * Date : 09-01-2022
 * Description : EmployeeService layer Implementation
*/
@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	public IEmployeeRepository employeeRepository;

	/************************************************************************************
	 * Method: addEmployee Description: It is used to add Employee into Employee
	 * table
	 * 
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By- Created Date -
	 * 
	 ************************************************************************************/
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO emp) {
		Employee ent = convertToEntity(emp);
		Employee updatedEnt = employeeRepository.save(ent);
		return convertToDTO(updatedEnt);
	}

	/************************************************************************************
	 * Method: deleteEmployee Description: It is used to delete Employee from the
	 * Employee table
	 * 
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By- Created Date
	 * 
	 ************************************************************************************/
	@Override
	public void deleteEmployee(int userId) {
		employeeRepository.deleteById(userId);
	}

	/************************************************************************************
	 * Method: updateEmployee Description: It is used to update employee into
	 * Employee table
	 * 
	 * @returns EmployeeDTO It returns Employee with updated details
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By-RIDDHIMAN GHOSH ROY Created Date
	 *            -18-05-2021
	 * 
	 ************************************************************************************/
	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO emp) {
		Employee ent = convertToEntity(emp);
		Employee updatedEnt = employeeRepository.save(ent);
		return convertToDTO(updatedEnt);
	}

	/************************************************************************************
	 * Method: getAllEmployees Description: It is used to view all Employees in
	 * employee table
	 * 
	 * @returns List<EmployeeDTO> It returns all the employees with details
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By- Created Date -
	 * 
	 ************************************************************************************/
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		Iterable<Employee> emps = employeeRepository.findAll();
		List<EmployeeDTO> dtoList = new ArrayList<>();
		for (Employee employee : emps) {
			EmployeeDTO dto = convertToDTO(employee);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/************************************************************************************
	 * Method: getEmployeeById Description: It is used to get employee in Employee
	 * table by userId
	 * 
	 * @returns <Employee> It returns Employee with details
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By- Created Date -
	 * 
	 ************************************************************************************/
	@Override
	public Optional<Employee> getEmployeeById(int userId) {
		if(!employeeRepository.existsById(userId)) {
			throw new EmployeeNotFoundException("Oops!!No User found for given Id");
		}
		else {
			return employeeRepository.findById(userId);

		}
	}

	/************************************************************************************
	 * Method: getEmployeeCount Description: It is used to get the count of all
	 * employees in the employee table
	 * 
	 * @returns long It returns the count of employees
	 * @Override: It is used to override the JpaRepository methods for performing
	 *            CURD operations. Created By- Created Date -
	 * 
	 ************************************************************************************/
	@Override
	public long getEmployeeCount() {
		return employeeRepository.count();
	}

	EmployeeDTO convertToDTO(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setFirstName(emp.getFirstName());
		dto.setLastName(emp.getLastName());
		dto.setDob(emp.getDob());
		dto.setEmail(emp.getEmail());
		dto.setUserId(emp.getUserId());
		dto.setDepartment(emp.getDepartment());
		return dto;
	}

	Employee convertToEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setDob(dto.getDob());
		entity.setEmail(dto.getEmail());
		entity.setUserId(dto.getUserId());
		entity.setDepartment(dto.getDepartment());
		;
		return entity;

	}
	
}

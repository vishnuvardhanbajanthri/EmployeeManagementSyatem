package com.capg.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ems.dto.EmployeeDTO;
import com.capg.ems.entities.Employee;
import com.capg.ems.exceptions.EmployeeNotFoundException;
import com.capg.ems.service.IEmployeeServiceImpl;
/*EmployeeController for Employee Management System
 * Author: Riyanka Ghosh
 * Date Created: 10/01/2022
 */
@RestController
@RequestMapping(value = "employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeManagementController {
	@Autowired
	private IEmployeeServiceImpl service;

	/************************************************************************************
	 * Method: createEmployee Description: It is used to add employee into employee
	 * table
	 * 
	 * @returns quote: It returns quote with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping(path = "/create")
	public ResponseEntity<Boolean> CreateEmployee(@RequestBody EmployeeDTO emp) {
		service.addEmployee(emp);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	/************************************************************************************
	 * Method: findEmployeeById Description: It is used to retrieve employee from
	 * the employee table by checking the id
	 * 
	 * @returns List<quote>: It returns List of quote with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping(path = "/getdetails/{userId}")
	public ResponseEntity<List<EmployeeDTO>> findEmployeeById(@PathVariable("userId") int userId) {
		Optional<Employee> emp = service.getEmployeeById(userId);
		if (emp == null) {
			throw new EmployeeNotFoundException("employee not found for id=" + userId);
		}
		return new ResponseEntity<List<EmployeeDTO>>(new HttpHeaders(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: findAll Description: It is used to retrieve all the Employees from
	 * the Employee table
	 * 
	 * @returns List<Employee>: It returns List of quote with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> list = service.getAllEmployees();
		return new ResponseEntity<List<EmployeeDTO>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: updateEmployee Description: It is used to update a Employee record
	 * from employee table
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping(path = "/update")
	public String updateEmployee(@RequestBody EmployeeDTO emp) {
		service.updateEmployee(emp);
		return "Employee updated successfully";
	}

	/************************************************************************************
	 * Method: deleteEmployee Description: It is used to delete a Employee record
	 * from Employee table
	 * 
	 * @returns String: It returns string value specifying successful deletion or
	 *          failure of deletion
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 *                 given URI expression.
	 * @PathVariable: It is used to handle template variables in the request URI
	 *                mapping.
	 ************************************************************************************/
	@DeleteMapping(path = "/delete/{userId}")
	public String deleteEmployee(@PathVariable("userId") int userId) {
		service.deleteEmployee(userId);
		return "Deleted";
	}

	/************************************************************************************
	 * Method: getEmployeeCount Description: It is used to get the count of
	 * employees from the employee table
	 * 
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * 
	 ************************************************************************************/

	@GetMapping("/count")
	public long getEmployeeCount() {
		return service.getEmployeeCount();
	}
}

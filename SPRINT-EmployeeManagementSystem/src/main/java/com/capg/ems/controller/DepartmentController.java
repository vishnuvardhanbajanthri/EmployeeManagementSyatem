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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ems.entities.Department;
import com.capg.ems.service.DepartmentServiceimpl;
/*Controller Class for Employee Management System
Author : NIKHIL KUMAR
Date Created : 10/01/2022
*/

@RestController
@RequestMapping(value = "department")
@CrossOrigin("http://localhost:4200")
public class DepartmentController {
	@Autowired
	private DepartmentServiceimpl service;

	/************************************************************************************
	 * Method: addDepartment Description: It is used to inserting department into department table
	 * 
	 * 
	 * @returns quote: It returns quote with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping(path = "/add")
	public ResponseEntity<Boolean> addDepartment(@RequestBody Department dName) {
		service.addDepartment(dName);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	/************************************************************************************
	 * Method: deleteDepartmentByID Description: It is used to deleting department by id from the department table
	 * 
	 * 
	 * @returns String: It returns string value specifying successful deletion or
	 *          failure of deletion
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 *                 given URI expression.
	 * @PathVariable: It is used to handle template variables in the request URI
	 *                mapping.
	 ************************************************************************************/
	@DeleteMapping("/department/{id}")
	public void deleteDepartmentByID(@PathVariable int id) {
		service.deleteDepartmentByID(id);
	}

	//
	/************************************************************************************
	 * Method: getAllDepartments Description: It is used to getting all the departments from the department table
	 * 
	 * 
	 * @returns List<Employee>: It returns List of quote with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> list = service.getAllDepartments();

		return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);

	}

	//
	/************************************************************************************
	 * Method: getDepartmentById Description: It is used to Getting department by Id from the department table
	 * 
	 * @returns List<quote>: It returns List of quote with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * @PathVariable: It is used to handle template variables in the request URI
	 *                mapping.
	 ************************************************************************************/
	@GetMapping("/department/{id}")
	public Optional<Department> getDepartmentById(@PathVariable int id) {
		return service.getDepartmentById(id);
	}

	//Getting the count of department from the department table
	/************************************************************************************
	 * Method: counts Description: It is used to Getting the count of department from the department table
	 * 
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * 
	 ************************************************************************************/
	@GetMapping("/count")
	public long counts() {
		return service.counts();
	}

}

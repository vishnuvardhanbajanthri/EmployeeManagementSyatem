package com.capg.ems.service;

import java.util.List;
import java.util.Optional;

import com.capg.ems.entities.Department;
import com.capg.ems.exceptions.DepartmentNotFoundException;

/*Service Interface for Employee Management System
Author : NIKHIL KUMAR
Date Created : 8/01/2022
*/

public interface IDepartmentService  {

	List<Department> getAllDepartments();
	
	Optional<Department> getDepartmentById(int id) throws DepartmentNotFoundException;

	void addDepartment(Department dName);

	void deleteDepartmentByID(int id);

	long counts();

}

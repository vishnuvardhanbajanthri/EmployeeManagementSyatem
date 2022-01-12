package com.capg.ems.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ems.entities.Employee;
/*Repository Interface for Employee Management System
Author : Riyanka
Date Created : 7/01/2022
Description : Employee repository
*/
@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{

	
	
}

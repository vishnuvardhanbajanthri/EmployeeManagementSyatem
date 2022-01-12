package com.capg.ems.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capg.ems.entities.Department;
/*Repository Interface for Employee Management System
Author : NIKHIL KUMAR
Date Created : 7/01/2022
Description : Deportment repository
*/
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
package com.capg.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.entities.Department;
import com.capg.ems.exceptions.DepartmentNotFoundException;
import com.capg.ems.repositories.DepartmentRepository;
/*
 * Author : NIKHIL KUMAR
 * Date : 09-01-2022
 * Description : DepartmentService layer Implementation
*/
@Service
public class DepartmentServiceimpl implements IDepartmentService {
	@Autowired
	DepartmentRepository departDao;

	/************************************************************************************
	 * Method: addDepartment 
	 * Description: It is used to add Department into
	 *              Department table
	 */
	@Override
	public void addDepartment(Department dName) {
		departDao.save(dName);
	}

	/************************************************************************************
	 * Method: deleteDepartmentById 
	 * Description: It is used to delete Department from
	 *              the Department table of respective id
	 */
	@Override
	public void deleteDepartmentByID(int id) {
		departDao.deleteById(id);
	}

	/************************************************************************************
	 * Method: getAllDepartments
	 *  Description: It is used to get All department data
	 *               from Department table
	 */
	@Override
	public List<Department> getAllDepartments() {
		List<Department> depts = (List<Department>) departDao.findAll();
		return depts;
	}

	/************************************************************************************
	 * Method: getDepartmentById 
	 * Description: It is used to get All department data
	 *              By Id from Department table
	 */
	@Override
	public Optional<Department> getDepartmentById(int id) {
		if(!departDao.existsById(id))
			throw new DepartmentNotFoundException("Department not found");
		else {
		return departDao.findById(id);
	}
	}

	/************************************************************************************
	 * Method: counts 
	 * Description: It is used to get count of Records from department table
	 */
	@Override
	public long counts() {
		return departDao.count();

	}

}

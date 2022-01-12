package com.capg.ems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.ems.entities.Department;
import com.capg.ems.exceptions.DepartmentNotFoundException;
import com.capg.ems.repositories.DepartmentRepository;
import com.capg.ems.service.DepartmentServiceimpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {

	@InjectMocks
	private DepartmentServiceimpl service;
	
	@Mock
	private DepartmentRepository departDao;
	
	@Test
	public void getAllDepartmentsTest()
	{
		Department obj1=new Department();
		Department obj2=new Department();
			obj1.setDepartId(1);
			obj2.setDepartId(2);
			obj1.setdName("devops");
			obj2.setdName("cloud");
			Mockito.when(departDao.findAll()).thenReturn(Stream.of(obj1,obj2).collect(Collectors.toList()));
			assertEquals(2,service.getAllDepartments().size());
	}
	@Test
	public void deleteDepartmentByID() throws DepartmentNotFoundException
	{
			Department obj=new Department();
			obj.setDepartId(1);
			obj.setdName("developer");
			Mockito.when(departDao.existsById(1)).thenReturn(true);
			service.deleteDepartmentByID(1);
			verify(departDao,Mockito.atLeastOnce()).deleteById(1);
	}
	@Test
	public void addDepartmentTest()
	{
		Department department = new Department();
		department.setDepartId(1);
		department.setdName("manager");
		
		Mockito.when(departDao.save(department)).thenReturn(department);
		//assertEquals(department,service.addDepartment(department));
    }
}
	

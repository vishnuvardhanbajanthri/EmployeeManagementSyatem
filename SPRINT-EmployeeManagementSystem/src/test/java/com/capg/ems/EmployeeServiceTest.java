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

import com.capg.ems.entities.Employee;
import com.capg.ems.exceptions.EmployeeNotFoundException;
import com.capg.ems.repositories.IEmployeeRepository;
import com.capg.ems.service.IEmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@InjectMocks
	private IEmployeeServiceImpl service;
	
	@Mock
	private  IEmployeeRepository employeeRepository;
	
	@Test
	public void addEmployeeTest()
	{
		Employee emp=new Employee();
		emp.setUserId(1);
		//emp.setDob(2021-12-02);
		emp.setFirstName("sai");
		emp.setLastName("sravan");
		emp.setEmail("sravandatha");
		Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
	}
	@Test
	public void getAllEmployees()
	{
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		emp1.setUserId(1);
		//emp.setDob(2021-12-02);
		emp1.setFirstName("vasu");
		emp1.setLastName("kiran");
		emp1.setEmail("vasu@gmail.com");
		emp2.setUserId(2);
		//emp.setDob(2021-12-02);
		emp2.setFirstName("kiran");
		emp2.setLastName("rao");
		emp2.setEmail("kiranrao@gmail.com");
		Mockito.when(employeeRepository.findAll()).thenReturn(Stream.of(emp1,emp2).collect(Collectors.toList()));
		assertEquals(2,service.getAllEmployees().size());	
	}
	@Test
	public void deleteEmployee() throws EmployeeNotFoundException
	{
			Employee emp=new Employee();
			emp.setUserId(1);
			//emp.setDob(2021-12-02);
			emp.setFirstName("ram");
			emp.setLastName("mohan");
			emp.setEmail("mohan");
			Mockito.when(employeeRepository.existsById(1)).thenReturn(true);
			service.deleteEmployee(1);
			verify(employeeRepository,Mockito.atLeastOnce()).deleteById(1);
	}
	
}

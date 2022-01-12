package com.capg.ems;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.ems.entities.Compliance;
import com.capg.ems.exceptions.EmployeeNotFoundException;
import com.capg.ems.repositories.IComplianceRepository;
import com.capg.ems.service.IComplianceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplianceTest {
	@InjectMocks
	private IComplianceServiceImpl complianceservice;
	@Mock
	private IComplianceRepository icomplianceRepository;

	// add method
	@Test
	public void addCompliance() {
		Compliance obj = new Compliance();
		obj.setComplianceId(1);
		obj.setItype("dveloper");
		obj.setDetails("java");
		obj.setStatus("open");
		Mockito.when(icomplianceRepository.save(obj)).thenReturn(obj);
	}

	@Test
	public void getAllCompliances() {
		Compliance obj1 = new Compliance();
		Compliance obj2 = new Compliance();
		obj1.setComplianceId(1);
		obj1.setItype("testing");
		obj1.setDetails("automition");
		obj1.setStatus("open");
		obj2.setComplianceId(2);
		obj2.setItype("developer");
		obj2.setDetails("jdk");
		obj2.setStatus("close");
		Mockito.when(icomplianceRepository.findAll()).thenReturn(Stream.of(obj1, obj2).collect(Collectors.toList()));
		assertEquals(2, complianceservice.getAllCompliances().size());
	}

	@Test
	public void updateCompliance() throws EmployeeNotFoundException {
		Compliance obj = new Compliance();
		obj.setComplianceId(1);
		obj.setItype("developer");
		obj.setDetails("spring");
		obj.setStatus("closed");
		Mockito.when(icomplianceRepository.save(obj)).thenReturn(obj);
	}

}

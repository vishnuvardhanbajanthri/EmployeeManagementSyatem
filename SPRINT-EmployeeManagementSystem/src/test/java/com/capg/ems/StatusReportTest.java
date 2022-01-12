package com.capg.ems;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.capg.ems.entities.StatusReport;
import com.capg.ems.exceptions.StatusReportNotFoundException;
import com.capg.ems.repositories.StatusReportRepository;
import com.capg.ems.service.StatusReportServiceimpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusReportTest {
	@InjectMocks
	private StatusReportServiceimpl iservice;
	@Mock
	private StatusReportRepository Dao;
	@Test
	public void addStatusReportTest()
	{
		StatusReport statusreport = new StatusReport();
		statusreport.setStatusId(1);
		statusreport.setComments("please allow  the permition ");
		statusreport.setDetails("Jdk");
		statusreport.setStatusreport("open");
		Mockito.when(Dao.save(statusreport)).thenReturn(statusreport);
	}
	@Test
	public void getAllStatusReportsTest() {
		StatusReport statusreport1 = new StatusReport();
		StatusReport statusreport2 = new StatusReport();
		statusreport1.setStatusId(1);
		statusreport1.setComments("please give the permtion");
		statusreport1.setDetails("Spring tool");
		statusreport1.setStatusreport("open");
		statusreport2.setStatusId(1);
		statusreport2.setComments("please give the permition");
		statusreport2.setDetails("MYSQL ");
		statusreport2.setStatusreport("close");
			Mockito.when(Dao.findAll()).thenReturn(Stream.of(statusreport1,statusreport2).collect(Collectors.toList()));
			assertEquals(2,iservice.getAllStatusReports().size());
	}
	@Test
	public void deleteStatusReportTest() throws StatusReportNotFoundException
	{
		   StatusReport statusreport = new StatusReport();
			statusreport.setStatusId(1);
			statusreport.setComments(" reslove the issue please");
			statusreport.setDetails("devops Connector");
			statusreport.setStatusreport("open");
					
	        Mockito.when(Dao.existsById(1)).thenReturn(true);
				iservice.deleteStatusReport(1);
				verify(Dao,Mockito.atLeastOnce()).deleteById(1);
			  }
}


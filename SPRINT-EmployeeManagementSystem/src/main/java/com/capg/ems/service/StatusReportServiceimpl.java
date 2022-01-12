package com.capg.ems.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.entities.StatusReport;
import com.capg.ems.exceptions.StatusReportNotFoundException;
import com.capg.ems.repositories.StatusReportRepository;
/*
 * Author : Vishnuvardhan
 * Date : 08-01-2022
 * Description : StatusReport layer Implementation
*/
@Service
public class StatusReportServiceimpl implements IStatusReportService  {
	@Autowired
	public StatusReportRepository statusDao;
	
	@Override
	public void addStatusReport(StatusReport statusreport) {
		statusDao.save(statusreport);
	}
	
	@Override
	public List<StatusReport> getAllStatusReports(){
		List<StatusReport> sts = (List<StatusReport>)statusDao.findAll(); 
		return sts;
	}
	@Override
	public long counts() {
		return  statusDao.count();
		
    }
	@Override
	public void deleteStatusReport(int statusId){
		statusDao.deleteById(statusId);
	}
	@Override
	public StatusReport updateStatusReport(StatusReport statusReport) throws StatusReportNotFoundException	 {
		 if(!statusDao.existsById(statusReport.getStatusId()))
			throw new StatusReportNotFoundException("Status Not Found");
	
		 statusDao.save(statusReport);
	     return statusReport;	
}
}
    

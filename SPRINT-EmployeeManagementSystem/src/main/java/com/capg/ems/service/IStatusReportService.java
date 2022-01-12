package com.capg.ems.service;

import java.util.List;

import com.capg.ems.entities.StatusReport;
import com.capg.ems.exceptions.StatusReportNotFoundException;

/*
 * StatusReportService Interface for EmployeeManagementSystem
 * Author : Vishnuvardhan
 * Date Created :07/01/2021
 */

public interface IStatusReportService {
	
	 void addStatusReport(StatusReport statusreport);
	 List<StatusReport> getAllStatusReports();
	 long counts();
	 void deleteStatusReport(int statusId);
	 StatusReport updateStatusReport(StatusReport statusReport) throws StatusReportNotFoundException;
	}



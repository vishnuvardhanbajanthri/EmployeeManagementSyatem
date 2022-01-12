package com.capg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ems.entities.StatusReport;
import com.capg.ems.service.StatusReportServiceimpl;
/*
 * StatusReportController Class for EmployeeManagementSystem
 * Author : Vishnuvardhan
 * Date Created :10/01/2021
 */
@RestController
@RequestMapping(value = "StatusReport")
@CrossOrigin("http://localhost:4200")
public class StatusReportController {
	@Autowired
	private StatusReportServiceimpl service;

	// Adding StatusReport into status_report table
	/************************************************************************************
	 * Method: Adding StatusReport into status_report table
	 * 
	 * @returns quote: It returns quote with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping(path = "/add")
	public ResponseEntity<Boolean> addStatusReport(@RequestBody StatusReport statusreport) {
		service.addStatusReport(statusreport);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	/************************************************************************************
	 * Method: To get all the Statusreports from status_report table
	 * 
	 * @returns List<Statusreport>: It returns List of Statusreport with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<StatusReport>> getAllStatusReports() {
		List<StatusReport> list = service.getAllStatusReports();
		return new ResponseEntity<List<StatusReport>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	/************************************************************************************
	 * Method: getStatusCount Description: It is used to get the count of
	 * Status from the Status table
	 * 
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * 
	 ************************************************************************************/
	//getting count of records from the table
	@GetMapping("/count")
	public long counts() {
		return service.counts();
	}
	
	/************************************************************************************
	 * Method: updateStatusReport Description: It is used to update a Status_reportabble
	 * from employee table
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/updateStatus")
	public String updateStatusReport(@RequestBody StatusReport statusreport) {
		service.updateStatusReport(statusreport);
		return "Status updated successfully";
	}

}

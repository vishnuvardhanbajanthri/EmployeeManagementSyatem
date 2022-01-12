package com.capg.ems.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * StatusReportController Class for EmployeeManagementSystem
 * Author : Vishnuvardhan
 * Date Created :10/01/2021
 */
@Entity
@Table(name="statusReport")
public class StatusReport {
	
	@Id
	private int statusId;
	private String comments;
	private String details;
	private LocalDate createDate;
	private String statusreport;
	@OneToOne(mappedBy = "statusReport",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Department department;
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public String getStatusreport() {
		return statusreport;
	}
	public void setStatusreport(String statusreport) {
		this.statusreport = statusreport;
	}

}


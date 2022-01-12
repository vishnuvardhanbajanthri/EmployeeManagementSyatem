package com.capg.ems.entities;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
/*Controller Class for Employee Management System
Author : NIKHIL KUMAR
Date Created : 10/01/2022
*/
@Entity
@Table(name="department")
public class Department {

	@Id
	private int departId;
	private String dName;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="departId")
	private Employee employee;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="departId")
	private Compliance compliance;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="departId")
	private StatusReport statusReport;
	
	public StatusReport getStatusReport() {
		return statusReport;
	}
	public void setStatusReport(StatusReport statusReport) {
		this.statusReport = statusReport;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Compliance getCompliance() {
		return compliance;
	}
	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	
}
	
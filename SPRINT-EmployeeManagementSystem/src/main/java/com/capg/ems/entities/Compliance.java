package com.capg.ems.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * Author : TANNU KUMARI
 * Date : 10-01-2022
 * Description : Compliance controller layer Implementation
*/
@Entity
@Table(name="compliance")
public class Compliance {
	
	@Id
	@Column(name="complianceId")
	private int complianceId;
	private String itype;
	private String details;
	private LocalDate createdate;
	private String status;
	
	@OneToOne(mappedBy = "compliance",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Department department;
	
	public Department getDepartment() {
	return department;
	}	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public int getComplianceId() {
		return complianceId;
	}

	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

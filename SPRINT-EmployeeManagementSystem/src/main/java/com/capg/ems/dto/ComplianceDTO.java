package com.capg.ems.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * Author : TANNU KUMARI
 * Date : 06-01-2022
 * Description : Compliance Entity Implementation
*/
public class ComplianceDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
    @JsonProperty("complianceId")
	private int complianceId;

	@NotEmpty(message = "IType cannot be empty")
    @JsonProperty("IType")
	private String itype;
	
	@NotEmpty(message = "Details cannot be empty")
    @JsonProperty("Details")
	private String details;
	
	@NotNull
    @JsonProperty("CreateDate")
	private LocalDate createdate;
	
	@NotEmpty(message = "Status cannot be empty")
    @JsonProperty("Status")
	private String status;
	
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

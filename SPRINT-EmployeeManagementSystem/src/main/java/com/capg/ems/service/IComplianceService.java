package com.capg.ems.service;

import java.util.List;
import java.util.Optional;

import com.capg.ems.dto.ComplianceDTO;
import com.capg.ems.entities.Compliance;
import com.capg.ems.exceptions.ComplianceNotFoundException;

/*
 * Author : TANNU KUMARI
 * Date : 06-01-2022
 * Description : Compliance service Interface 
*/

public interface IComplianceService {
	
	public ComplianceDTO addCompliance(ComplianceDTO com);
	public List<ComplianceDTO> getAllCompliances();
	public Optional<Compliance> getComplianceById(int complianceId);
	ComplianceDTO updateCompliance(ComplianceDTO compliance) throws ComplianceNotFoundException;
	public void deleteCompliance(int complianceId);
}

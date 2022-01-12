package com.capg.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.dto.ComplianceDTO;
import com.capg.ems.entities.Compliance;
import com.capg.ems.exceptions.ComplianceNotFoundException;
import com.capg.ems.repositories.IComplianceRepository;
/*
 * Author : TANNU KUMARI
 * Date : 09-01-2022
 * Description : Compliance service layer Implementation
*/
@Service
public class IComplianceServiceImpl implements IComplianceService {

	@Autowired
	IComplianceRepository icomplianceRepository;

	/************************************************************************************
	 * Method: addCompliance Description: It is used to add compliance into
	 * Compliance table
	 */
	@Override
	public ComplianceDTO addCompliance(ComplianceDTO com) {
		Compliance c = convertToEntity(com);
		Compliance updatedC = icomplianceRepository.save(c);
		return convertToDTO(updatedC);

	}

	/************************************************************************************
	 * Method: getAllCompliances Description: It is used to get All compliances data
	 * from compliance table
	 */
	@Override
	public List<ComplianceDTO> getAllCompliances() {
		Iterable<Compliance> comps = icomplianceRepository.findAll();
		List<ComplianceDTO> dtoList = new ArrayList<>();
		for (Compliance compliance : comps) {
			ComplianceDTO dto = convertToDTO(compliance);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/************************************************************************************
	 * Method: getComplianceById Description: It is used to get All compliance data
	 * By Id from Compliance table
	 */
	@Override
	public Optional<Compliance> getComplianceById(int complianceId) {

		if (!icomplianceRepository.existsById(complianceId)) {
			throw new ComplianceNotFoundException("Oops!!No User found for given Id");
		} else {
			return icomplianceRepository.findById(complianceId);
		}
	}

	/************************************************************************************
	 * Method: updateCompliance Description: It is used to update compliance records
	 * of compliance table
	 */
	@Override
	public ComplianceDTO updateCompliance(ComplianceDTO compliance) {
		Compliance com = convertToEntity(compliance);
		Compliance updatedEnt = icomplianceRepository.save(com);
		return convertToDTO(updatedEnt);
	}
	
	public void deleteCompliance(int complianceId) {
		if (!icomplianceRepository.existsById(complianceId)) {
			throw new ComplianceNotFoundException("Oops!!No User found for given Id");
		} else {
		 icomplianceRepository.deleteById(complianceId);
	}
	}
	

	ComplianceDTO convertToDTO(Compliance com) {
		ComplianceDTO dto = new ComplianceDTO();
		dto.setItype(com.getItype());
		dto.setDetails(com.getDetails());
		dto.setCreatedate(com.getCreatedate());
		dto.setStatus(com.getStatus());
		dto.setComplianceId(com.getComplianceId());
		return dto;
	}

	Compliance convertToEntity(ComplianceDTO dto) {
		Compliance entity = new Compliance();
		entity.setItype(dto.getItype());
		entity.setDetails(dto.getDetails());
		entity.setCreatedate(dto.getCreatedate());
		entity.setStatus(dto.getStatus());
		entity.setComplianceId(dto.getComplianceId());
		return entity;

	}

}

package com.capg.ems.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.capg.ems.dto.ComplianceDTO;
import com.capg.ems.entities.Compliance;
import com.capg.ems.service.IComplianceServiceImpl;

/*
 * Author : TANNU KUMARI
 * Date : 10-01-2022
 * Description : Compliance controller layer Implementation
*/
@RestController
public class ComplianceController {

	@Autowired
	IComplianceServiceImpl complianceService;

	/************************************************************************************
	 * Method: getAllCompliance Description: It is used to display all the
	 * information of compliances from Compliance table.
	 * 
	 * @GetMapping: It is used to handle GET type of request method Created By-
	 *              TANNU KUMARI Created Date - 10-01-2022
	 ************************************************************************************/

	@GetMapping("/compliances")
	public List<ComplianceDTO> getAllCompliance() {
		return complianceService.getAllCompliances();
	}

	/************************************************************************************
	 * Method: getCompliance Description: It is used to display information of
	 * compliance from Compliance table by ID.
	 * 
	 * @GetMapping: It is used to handle GET type of request method Created By-
	 *              TANNU KUMARI Created Date - 10-01-2022
	 ************************************************************************************/
	@GetMapping("/compliances/{id}")
	public Optional<Compliance> getCompliance(@PathVariable int id) {
		return complianceService.getComplianceById(id);
	}

	/************************************************************************************
	 * Method: addCompliances Description: It is used to inserting compliance into
	 * Compliance table using mapping.
	 * 
	 * @PostMapping is used to handle POST type of request method Created By- TANNU
	 *              KUMARI Created Date - 09-01-2022
	 ************************************************************************************/

	@PostMapping("/compliances")
	public @ResponseBody String addCompliances(@RequestBody @Valid ComplianceDTO compliance) {
		complianceService.addCompliance(compliance);
		return "Compliance Added Successfully";
	}

	/************************************************************************************
	 * Method: updateCompliance Description: It is used to update compliance into
	 * Compliance table
	 * 
	 * @PutMapping is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. PUT)
	 * @RequestMapping used to map web requests onto specific handler classes and/or
	 *                 handler methods. Created By- TANNU KUMARI Created Date -
	 *                 09-01-2022
	 ************************************************************************************/
	@PutMapping("/updateCompliance")
	public String updateCompliance(@RequestBody ComplianceDTO compliance) {
		complianceService.updateCompliance(compliance);
		return "compliance updated successfully";
	}

	/************************************************************************************
	 * Method: deleteCompliance Description: It is used to delete the information of
	 * compliance from Compliance table by ID
	 * 
	 * @DeleteMapping annotation maps HTTP DELETE requests onto specific handler
	 *                methods Created By- TANNU KUMARI Created Date - 11-01-2022
	 ************************************************************************************/

	@DeleteMapping(path = "/delete/{id}")
	public String deleteCompliance(@PathVariable int id) {
		System.out.print("controller");
		complianceService.deleteCompliance(id);
		return "Compliance Deleted Successfully";
	}

}

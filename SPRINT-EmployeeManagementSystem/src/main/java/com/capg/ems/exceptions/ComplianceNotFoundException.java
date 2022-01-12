package com.capg.ems.exceptions;
/*Repository User Defined Exception for Employee Management System
 * Author : TANNU KUMARI
 * Date : 08-01-2022
 * Description : ComplianceNotFoundException
*/
public class ComplianceNotFoundException extends RuntimeException {
	
	public ComplianceNotFoundException(String message) {
		super(message);
	}
	
	public ComplianceNotFoundException(String message,Throwable e) {
		super(message,e);
	}

}

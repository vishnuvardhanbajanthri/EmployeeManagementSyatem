package com.capg.ems.exceptions;
/*Repository User Defined Exception for Employee Management System
Author : NIKHIL KUMAR
Date Created : 08/01/2022
Description : DepartmentNotFoundException
*/
public class DepartmentNotFoundException extends RuntimeException {
	
	    public DepartmentNotFoundException(String dep){
	        super(dep);
	    }

	    public DepartmentNotFoundException(String dep,Throwable e){
	        super(dep,e);
	    }
	}


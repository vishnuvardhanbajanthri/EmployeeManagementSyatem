package com.capg.ems.exceptions;
/*Repository User Defined Exception for Employee Management System
Author : Riyanka
Date Created : 08/01/2022
Description : EmployeeNotFoundException
*/
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }

    public EmployeeNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}

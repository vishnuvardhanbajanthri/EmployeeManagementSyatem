package com.capg.ems.exceptions;
/*Repository User Defined Exception for Employee Management System
 * Author : Vishnuvardhan
 * Date : 08-01-2022
 * Description : StatusReportNotFoundException
*/
public class StatusReportNotFoundException extends RuntimeException {
	
    public StatusReportNotFoundException(String message){
        super(message);
    }

    public StatusReportNotFoundException(String message,Throwable e){
        super(message,e);
    }

}

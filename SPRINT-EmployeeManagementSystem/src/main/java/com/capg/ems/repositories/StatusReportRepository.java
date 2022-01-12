package com.capg.ems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.ems.entities.StatusReport;
/*Repository Interface for Employee Management System
 * Author : Vishnuvardhan
 * Date : 07-01-2022
 * Description : Status repository
*/
@Repository
public interface StatusReportRepository extends CrudRepository<StatusReport, Integer> {

}
package com.capg.ems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.capg.ems.entities.Compliance;
/*Repository Interface for Employee Management System
 * Author : TANNU KUMARI
 * Date : 07-01-2022
 * Description : Compliance repository
*/
@Repository
public interface IComplianceRepository extends CrudRepository<Compliance, Integer> {

}

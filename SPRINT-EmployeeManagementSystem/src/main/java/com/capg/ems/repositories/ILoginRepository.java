package com.capg.ems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.ems.dto.UserDTO;
import com.capg.ems.entities.User;
/*Repository Interface for Employee Management System
 * Author : Vidya
 * Date : 07-01-2022
 * Description : User repository
*/
@Repository
public interface ILoginRepository extends CrudRepository<User, Integer>{
	
}

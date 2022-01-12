package com.capg.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.dto.UserDTO;
import com.capg.ems.entities.User;
import com.capg.ems.exceptions.UserNotFoundException;
import com.capg.ems.repositories.ILoginRepository;

/*
 * Author : Vidya
 * Date : 08-01-2022
 * Description : Userlayer Implementation
*/
@Service
public class ILoginServiceImpl implements ILoginService {

	@Autowired
	public ILoginRepository loginRepository;

	/*****************
	 * Method: addUser
	 * Description: It is used to add User into User table 
	 ******************/
	@Override
	public UserDTO addUser(UserDTO user) {
		User ent = convertToEntity(user);
		User updatedEnt = loginRepository.save(ent);
		return convertToDTO(updatedEnt);
	}

	/********************
	 * Method: deleteUser
	 * Description: It is used to delete User from User table 
	 *********************/
	@Override
	public void deleteUser(int userId) {
		loginRepository.deleteById(userId);
	}

	/*******************
	 * Method: updateUser
	 * Description: It is used to update User into User table 
	 ********************/
	@Override
	public UserDTO updateUser(UserDTO user) {
		User ent = convertToEntity(user);
		User updatedEnt = loginRepository.save(ent);
		return convertToDTO(updatedEnt);

	}

	/*********************
	 * Method: GetALLUsers
	 * Description: It is used to getall user records from User table
	 **********************/
	@Override
	public List<UserDTO> getAllUsers() {
		Iterable<User> user = loginRepository.findAll();
		List<UserDTO> dtoList = new ArrayList<>();
		for (User u : user) {
			UserDTO dto = convertToDTO(u);
			dtoList.add(dto);
		}
		return dtoList;
	}
	/*********************
	 * Method: findUserbyId
	 * Description: It is used to find user record of given Id from User table
	 **********************/
	@Override
	public Optional findUserbyId(int userId) throws UserNotFoundException
	{
		if(!loginRepository.existsById(userId)) {
			throw new UserNotFoundException("Oops!!No User found for given Id");
		}
		else {
			return loginRepository.findById(userId);
		}
	}
	
	UserDTO convertToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUserId(user.getUserId());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		return dto;
	}
	
	User convertToEntity(UserDTO dto) {
		User entity = new User();
		entity.setUserId(dto.getUserId());
		entity.setPassword(dto.getPassword());
		entity.setRole(dto.getRole());
		return entity;

	}
}

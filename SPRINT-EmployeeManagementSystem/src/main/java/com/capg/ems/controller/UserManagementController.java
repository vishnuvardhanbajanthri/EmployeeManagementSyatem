package com.capg.ems.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ems.dto.UserDTO;
import com.capg.ems.entities.User;
import com.capg.ems.exceptions.UserNotFoundException;
import com.capg.ems.service.ILoginServiceImpl;
/*
 * Author : VIDYA
 * Date : 10-01-2022
 * Description : User controller layer implementation
 */
@RestController
public class UserManagementController {

	static final Logger logger = LogManager.getLogger(UserManagementController.class.getName());

	@Autowired
	private ILoginServiceImpl loginService;

	// displaying list of all users
	/************************************************************************************
	 * Method: getAllUsers Description: It is used to retrieve all the users 
	 * 
	 * 
	 * @returns List<Employee>: It returns List of quote with details
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/users")
	public List<UserDTO> getAllUsers() {
		return loginService.getAllUsers();
	}

	
	/************************************************************************************
	 * Method: addUser Description: It is used to add user in table
	 * 
	 * @returns quote: It returns quote with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * @Valid	:  it use to validate the data passed into the controller
	 * @ResponseBody :it is use to us retrieve the request's body
	 ************************************************************************************/
	
	@PostMapping("/users")
	public @ResponseBody String addUser(@RequestBody @Valid UserDTO user) {
		loginService.addUser(user);
		return "User Added Successfully";
	}

	// updating user by id
	/************************************************************************************
	 * Method: updateUser Description: It is used to updating user by id
	 * 
	 * @returns quote: It returns quote with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * @Valid	:  it use to validate the data passed into the controller
	 * @ResponseBody :it is use to us retrieve the request's body
	 ************************************************************************************/
	@PutMapping("/users/{id}")
	public @ResponseBody String updateUser(@RequestBody @Valid UserDTO u) {
		loginService.updateUser(u);
		return "User Updated Successfully";
	}

	
	/************************************************************************************
	 * Method: deleteUser Description: It is used to delete a User by id
	 * 
	 * @ResponseBody :it is use to us retrieve the request's body
	 * @returns String: It returns string value specifying successful deletion or
	 *          failure of deletion
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 *                 given URI expression.
	 * @PathVariable: It is used to handle template variables in the request URI
	 *                mapping.
	 ************************************************************************************/
	@DeleteMapping("users/{id}")
	public @ResponseBody String deleteUser(@RequestBody User u, @PathVariable int id) {
		loginService.deleteUser(id);
		return "User Deleted Successfully";
	}

	
	/************************************************************************************
	 * Method: findUserById Description: It is used to get  user by id
	 * 
	 * @GetMapping: annotated methods handle the HTTP GET requests matched with
	 *              given URI expression
	 * @PathVariable: It is used to handle template variables in the request URI
	 *                mapping.
	 ************************************************************************************/
	@GetMapping("/finduser/{id}")
	public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") int id) throws UserNotFoundException {
		Optional<User> findagent = loginService.findUserbyId(id);
		if (findagent == null)
			return new ResponseEntity("No Agent Found for given Id", HttpStatus.NOT_FOUND);
		return new ResponseEntity(findagent, HttpStatus.OK);
	}
}

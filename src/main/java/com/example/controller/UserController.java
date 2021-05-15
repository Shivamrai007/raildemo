package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.exception.UserNotFoundException;
import com.example.exception.handling.Message;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping("")
	public List<UserDTO> getAllUsersByPageSizeAndPageNum(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize) {
		logger.info("Fetching All Users...");
		return userService.getAllUsersByPageSizeAndPageNum(pageNumber, pageSize);
	}

	/**
	 * @param userDTO
	 * @return
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("")
	public ResponseEntity<?> register(@RequestBody @Valid UserDTO userDTO) throws MethodArgumentNotValidException {
		userService.saveUser(userDTO);
		logger.info("User saved Successfully");
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);

	}

	/**
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	@GetMapping("/{userId}")
	public UserDTO getUserById(@PathVariable Long userId) throws UserNotFoundException {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userService.getUserById(userId),userDTO);
		return userDTO;
	}

	/**
	 * @param userId
	 * @param user
	 * @return
	 * @throws UserNotFoundException
	 */
	@PutMapping("/{userId}")
	public ResponseEntity<?> UpdateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO)
			throws UserNotFoundException {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		User u = userService.updateUser(userId, user);
		if (u != null) {
			logger.info("User is successfully saved !!!");
			return ResponseEntity.ok(new Message("User is successfully saved !!!"));
		}
		logger.info("Please enter valid details");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("Please enter valid details"));

	}

	/**
	 * @param userId
	 */
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		logger.info("User Deletion in process starting...");
		userService.deleteUserById(userId);
		logger.info("User Deleted Successfully");
	}

}
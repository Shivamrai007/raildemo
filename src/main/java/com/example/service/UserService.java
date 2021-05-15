package com.example.service;

import java.util.List;

import com.example.dto.UserDTO;
import com.example.exception.UserNotFoundException;
import com.example.model.User;


/**
 * @author shivam.rai
 *
 */
public interface UserService {

	public void saveUser(UserDTO userDTO);
	
	public List<UserDTO> getAllUsers();
	
	public User getUserById(Long userId) throws UserNotFoundException;
	
	public List<UserDTO> getAllUsersByPageSizeAndPageNum(int pageNumber,int pageSize);
	
	public User updateUser(Long userId, User user) throws UserNotFoundException;
	
	public void deleteUserById(Long userId);
}

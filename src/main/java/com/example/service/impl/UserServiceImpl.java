package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.controller.UserController;
import com.example.dto.UserDTO;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * @author shivam.rai
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public void saveUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepository.save(user);
		logger.info("User Saved Successfully");
	}

	@Override
	public List<UserDTO> getAllUsers() {
		logger.info("Fetching All Users..");
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		List<User> user  = userRepository.findAll();
		
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsersByPageSizeAndPageNum(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		List<User> userList  = userRepository.findAll(pageable).getContent();
		
		for (User user : userList) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			userDTOList.add(userDTO);
		}
		
		return userDTOList;

	}

	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}
	
	  
	public void deleteUserById(Long userId) {
	        userRepository.deleteById(userId);
	        logger.info("User Deleted Successfully with userId",userId);
	    }

	    public User updateUser(Long userId, User user) throws UserNotFoundException {
	        User user2=getUserById(userId);
	        user2.setUsername(user.getUsername());
	        user2.setPassword(user.getPassword());
	        user2.setContactNo(user.getContactNo());
	        user2.setAge(user.getAge());
	        user2.setEmail(user.getEmail());
	        user2.setUserRole(user.getUserRole());
	        user2.setAddress(user.getAddress());
	        return userRepository.save(user2);
	    }
	 
}

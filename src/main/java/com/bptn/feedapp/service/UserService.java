package com.bptn.feedapp.service;

import java.util.Optional;
import com.bptn.feedapp.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bptn.feedapp.jdbc.UserBean;
import com.bptn.feedapp.jdbc.UserDao;
import com.bptn.feedapp.jpa.User;
import com.bptn.feedapp.jdbc.UserBean;


@Service
public class UserService {

	
	@Autowired
	UserDao userDao;
	@Autowired
	UserRepository userRepository;
	
	public List<User> listUsers() {
		return this.userRepository.findAll();
		}
	
	
	public Optional<User> findByUsername(String username) {
		return this.userRepository.findByUsername(username);
		}
	
	
	public void createUser(User user) {
		this.userRepository.save(user);
		}
}

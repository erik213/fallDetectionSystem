package com.br.fallDetectionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.User;
import com.br.fallDetectionSystem.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
    @Autowired
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
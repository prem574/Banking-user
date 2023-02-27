package com.stl.Banking.User.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stl.Banking.User.Entity.User;
import com.stl.Banking.User.Exception.ResourceNotFoundException;
import com.stl.Banking.User.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public ResponseEntity<User> findUserById(Long id) {
    	User user =  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+ id));
		return ResponseEntity.ok(user);
    }
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public ResponseEntity<User> updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+ id));
		
        
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setAddress(user.getAddress());
             userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        
       
    }
    
    @Override
    public ResponseEntity<HttpStatus> deleteUser(Long id) {
       User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+ id));
       userRepository.delete(user);
	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
}

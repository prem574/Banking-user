package com.stl.Banking.User.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stl.Banking.User.Entity.User;

public interface UserService {
    List<User> findAllUsers();
    ResponseEntity<User> findUserById(Long id);
    User saveUser(User user);
    ResponseEntity<User> updateUser(Long id, User user);
    ResponseEntity<HttpStatus> deleteUser(Long id);
	User findByUsername(String username);

}

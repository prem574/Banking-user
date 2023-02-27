package com.stl.Banking.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.Banking.User.Entity.Loginentity;
import com.stl.Banking.User.Entity.User;
import com.stl.Banking.User.Service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
   @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
      
  
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
    
    
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
    	 System.out.println(user);
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println(user);
            
          user =  userService.saveUser(user);
          System.out.println(user);
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().body(user);
        }
   }
        
    
    
  @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Loginentity login) {
        User existingUser = userService.findByUsername(login.getUsername());
        System.out.println(login);
        if (existingUser != null && bCryptPasswordEncoder.matches(login.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.ok().body(existingUser);
        } else {
            return ResponseEntity.badRequest().body(existingUser);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

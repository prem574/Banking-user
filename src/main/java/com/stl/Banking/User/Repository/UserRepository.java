package com.stl.Banking.User.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.Banking.User.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

 User findByUsername(String username);

  //Optional<User> findByUsername(String username);
}


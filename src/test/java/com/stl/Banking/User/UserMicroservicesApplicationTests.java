// package com.stl.Banking.User;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.stl.Banking.User.Entity.User;
// import com.stl.Banking.User.Repository.UserRepository;

// @SpringBootTest
// class UserMicroservicesApplicationTests {

// 	@Autowired
// 	UserRepository userRepo;
	
// 	@Test
// 	public void testCreate() {
// 		User a = new User();
// 	    a.setId(2l);
// 	    a.setFirstName("Vamsi");
// 	    a.setLastName("Krishna");
// 	    a.setEmail("vamsi@gmail.com");
// 	    a.setAddress("bvrm");
// 	    a.setUsername("vamsi");
// 	    a.setPassword("vamsi@123");
// 	    a.setPhoneNumber("6309176857");
// 	    userRepo.save(a);
// 	    assertNotNull(userRepo.findById(2l).get());
	  
// 	}
	
// 	@Test
// 	public void testRead() {
// 		List<User> list = userRepo.findAll();
// 		assertThat(list).size().isGreaterThan(0);
// 	}
	
// 	@Test
// 	public void testSingleUser() {
// 		User user = userRepo.findById(1l).get();
// 		assertEquals("prem",user.getUsername());
// 	}

// 	@Test
// 	public void testUpdate() {
// 		User u = userRepo.findById(2l).get();
// 		u.setPhoneNumber("8097543212");
// 		userRepo.save(u);
// 		assertNotEquals("8096202118",userRepo.findById(2l).get().getPhoneNumber());
// 	}
	
// 	@Test
// 	public void testDelete() {
// 		userRepo.deleteById(2l);
// 		assertThat(userRepo.existsById(2l)).isFalse();
// 	}
// }

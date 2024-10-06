package alten.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import alten.back.model.User;
import alten.back.model.UserRole;
import alten.back.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository; 
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	public User createUser(Integer id, String username, String password, UserRole role) {
		User user = new User(id, username, passwordEncoder.encode(password), role); 
		return userRepository.save(user);
		
	}
	public User saveUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword()); 
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
}

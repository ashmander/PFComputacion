package com.example.demo.services;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyUserPrincipal;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService 
{

	private UserRepository userRepository;
	
	@PostConstruct
	public void createUsers()
	{

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userRepository.save(new User("juan",passwordEncoder.encode("123")));
		userRepository.save(new User("ana",passwordEncoder.encode("123")));
		userRepository.save(new User("camilo",passwordEncoder.encode("123")));
		userRepository.save(new User("diana",passwordEncoder.encode("123")));
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(User user) {
		userRepository.save(user);

	}
	
	@Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new RuntimeException(username);
        }
        return new MyUserPrincipal(user.get());
    }

	public Optional<User> findById(long id) {

		return userRepository.findById(id);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}


	public void delete(User user) {
		userRepository.delete(user);

	}


}

package com.runadium.runadoc.service;

import java.util.List;
import java.util.Optional;

import com.runadium.runadoc.dto.reponse.JwtResponse;
import com.runadium.runadoc.model.User;


public interface UserService {
	
	
	public Optional<User> findByUsername(String username);

	public void updatePassword(String password, User user);

	public Optional<User> findByEmail(String email);

	public User save(User user);

	public List<User> findAllWithoutConnectedUser(Long id);
	
	public JwtResponse getUserInfo(String token, Optional<User> user);


}
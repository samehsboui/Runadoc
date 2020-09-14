package com.runadium.runadoc.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runadium.runadoc.dto.reponse.JwtResponse;
import com.runadium.runadoc.model.User;
import com.runadium.runadoc.repository.UserRepository;
import com.runadium.runadoc.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void updatePassword(String password, User user) {
		userRepository.updatePassword(password, user.getId());
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllWithoutConnectedUser(Long id) {
		return userRepository.findAllWithoutConnectedUser(id);
	}

	@Override
	public JwtResponse getUserInfo(String token, Optional<User> user) {
		String imageBase64 = "";
		JwtResponse jwtResponse = null;
		if (user.isPresent()) {
			if (user.get().getImage() != null) {
				imageBase64 = Base64.getEncoder().encodeToString(user.get().getImage());
			}
			jwtResponse = new JwtResponse(token, user.get().getEmail(), user.get().getFullName(), imageBase64);
		}
		return jwtResponse;
	}
}

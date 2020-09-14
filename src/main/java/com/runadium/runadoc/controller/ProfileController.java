package com.runadium.runadoc.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.runadium.runadoc.dto.reponse.ResponseMessage;
import com.runadium.runadoc.dto.request.UpdateProfileRequest;
import com.runadium.runadoc.model.User;
import com.runadium.runadoc.service.UserService;
import com.runadium.runadoc.utils.StringsConstants;

import io.swagger.annotations.Api;

@CrossOrigin(origins = StringsConstants.FRONT_BASE_URL, maxAge = 3600)
@Api("Profile Controller")
@RestController
@RequestMapping(StringsConstants.PROFILE_URL)
public class ProfileController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/updateInfo")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseMessage> updateInfo(@Valid @RequestBody UpdateProfileRequest updateProfileRequest) {

		Optional<User> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		user.get().setFullName(updateProfileRequest.getName());
		user.get().setEmail(updateProfileRequest.getEmail());
		userService.save(user.get());
		return new ResponseEntity<>(new ResponseMessage("Profile updated successfully"), HttpStatus.OK);
	}

	@PostMapping(value = "/updateImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseMessage> updateImage(@RequestParam("profileImage") MultipartFile profileImage)
			throws IOException {

		Optional<User> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		try {
			if (!profileImage.isEmpty()) {
				user.get().setImage(profileImage.getBytes());
			}
		} catch (IOException e) {
			return new ResponseEntity<>(new ResponseMessage("Error while uploading image"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		userService.save(user.get());
		return new ResponseEntity<>(new ResponseMessage("Image uploaded successfully"), HttpStatus.OK);
	}
}

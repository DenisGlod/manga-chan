package com.mangachan.controller;

import com.mangachan.service.UserService;
import com.mangachan.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class IndexController {
	private final UserService userService;

	@RequestMapping(path = {"/all-users"}, method = RequestMethod.GET)
	public List<UserDto> allUsers() {
		return userService.getAllUser();
	}

	@RequestMapping(path = {"/add-user"}, method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		Optional<UserDto> user = userService.findUserByUsername(userDto);
		if (user.isPresent()) {
			return ResponseEntity.ok().body("Пользователь существует!");
		} else {
			return ResponseEntity.ok().body(userService.save(userDto));
		}
	}

	@RequestMapping(path = {"/get-user-by-id/{id}"}, method = RequestMethod.GET)
	public Optional<UserDto> getUserById(@PathVariable("id") Long id) {
		return userService.findUserById(id);
	}

}

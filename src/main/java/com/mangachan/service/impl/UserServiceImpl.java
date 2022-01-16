package com.mangachan.service.impl;

import com.mangachan.dao.repository.UserRepository;
import com.mangachan.service.UserService;
import com.mangachan.service.dto.UserDto;
import com.mangachan.service.util.DTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final DTOConverter DTOConverter;

	@Override
	public List<UserDto> getAllUser() {
		var usersList = userRepository.findAll();
		return DTOConverter.userEntityToDto(usersList);
	}

	@Override
	public Optional<UserDto> findUserById(Long id) {
		var userOptional = userRepository.findById(id);
		return userOptional.map(DTOConverter::userEntityToDto);
	}

	@Override
	public Optional<UserDto> findUserByUsername(UserDto userDto) {
		var userOptional = userRepository.findByUsername(userDto.getUsername());
		return userOptional.map(DTOConverter::userEntityToDto);
	}

	@Override
	public UserDto save(UserDto bean) {
		var user = userRepository.save(DTOConverter.userDtoToEntity(bean));
		return DTOConverter.userEntityToDto(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var userOptional = userRepository.findByUsername(username);
		return userOptional.orElseThrow(() -> {
			throw new UsernameNotFoundException(String.format("User %s not found", username));
		});
	}

}

package com.mangachan.service.util;

import com.mangachan.dao.entity.User;
import com.mangachan.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class DTOConverter {

	private PasswordEncoder passwordEncoder;
	private ModelMapper modelMapper;

	public User userDtoToEntity(UserDto userDto) {
		log.info("UserBean -> {}", userDto.toString());
		Converter<String, String> encodeConverter =
				src -> src.getSource() == null ? null : passwordEncoder.encode(src.getSource());
		User user = modelMapper
				.typeMap(UserDto.class, User.class)
				.addMappings(mapper -> mapper.using(encodeConverter).map(UserDto::getPassword, User::setPassword))
				.map(userDto);
		log.info("UserEntity -> {}", user);
		return user;
	}

	public UserDto userEntityToDto(User entity) {
		TypeMap<User, UserDto> userUserDtoTypeMap = modelMapper.typeMap(User.class, UserDto.class).addMappings(mapper -> mapper.skip(UserDto::setPassword));
		log.info("UserEntity -> {}", entity.toString());
		UserDto user = userUserDtoTypeMap.map(entity);
		log.info("UserBean -> {}", user);
		return user;
	}

	public List<UserDto> userEntityToDto(List<User> entity) {
		List<UserDto> userDtoList = new ArrayList<>();
		entity.forEach(item -> userDtoList.add(userEntityToDto(item)));
		return userDtoList;
	}

}

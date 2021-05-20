package com.mangachan.service;

import com.mangachan.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUser();

    Optional<UserDto> findUserById(Long id);

    Optional<UserDto> login(String email, String password);

    UserDto save(UserDto bean);

    Optional<UserDto> delete(UserDto bean);
}

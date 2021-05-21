package com.mangachan.service;

import com.mangachan.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<UserDto> getAllUser();

    Optional<UserDto> findUserById(Long id);

    UserDto save(UserDto bean);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

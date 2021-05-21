package com.mangachan.service.impl;

import com.mangachan.dao.auth.User;
import com.mangachan.dao.repository.UserRepository;
import com.mangachan.service.UserService;
import com.mangachan.service.dto.UserDto;
import com.mangachan.service.util.Converter;
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

    @Override
    public List<UserDto> getAllUser() {
        var userList = userRepository.findAll();
        return Converter.userEntityToUserDto(userList);
    }

    @Override
    public Optional<UserDto> findUserById(Long id) {
        var userOptional = userRepository.findById(id);
        return userOptional.map(Converter::userEntityToUserDto);
    }

    @Override
    public UserDto save(UserDto bean) {
        var user = userRepository.save(Converter.userDtoToUserEntity(bean));
        return Converter.userEntityToUserDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElseThrow(() -> {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        });
    }

}

package com.mangachan.service.util;

import com.mangachan.dao.auth.Role;
import com.mangachan.dao.auth.User;
import com.mangachan.service.dto.RoleDto;
import com.mangachan.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Converter {

    public static User userDtoToUserEntity(UserDto userDto) {
        log.info("UserBean -> {}", userDto.toString());
        User user = User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        if (userDto.getRole() != null) {
            user.setRole(roleDtoToRoleEntity(userDto.getRole()));
        }
        log.info("UserEntity -> {}", user.toString());
        return user;
    }

    public static UserDto userEntityToUserDto(User entity) {
        log.info("UserEntity -> {}", entity.toString());
        UserDto user = UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(
                        roleEntityToRoleBean(entity.getRole()))
                .build();
        log.info("UserBean -> {}", user.toString());
        return user;
    }

    public static List<UserDto> userEntityToUserDto(List<User> entity) {
        List<UserDto> userDtoList = new ArrayList<>();
        entity.forEach(item -> userDtoList.add(userEntityToUserDto(item)));
        return userDtoList;
    }

    public static Role roleDtoToRoleEntity(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .build();
    }

    public static RoleDto roleEntityToRoleBean(Role entity) {
        return RoleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}

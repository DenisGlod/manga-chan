package com.mangachan.service.util;

import com.mangachan.dao.entity.Book;
import com.mangachan.dao.auth.Role;
import com.mangachan.dao.auth.User;
import com.mangachan.dao.entity.UserData;
import com.mangachan.service.dto.BookDto;
import com.mangachan.service.dto.RoleDto;
import com.mangachan.service.dto.UserDto;
import com.mangachan.service.dto.UserDataDto;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Converter {

    public static User userBeanToUserEntity(UserDto bean) {
        log.info("UserBean -> {}", bean.toString());
        User user = User.builder()
                .id(bean.getId())
                .email(bean.getEmail())
                .password(bean.getPassword())
                .build();
        if (bean.getRole() != null) {
            user.setRole(roleBeanToRoleEntity(bean.getRole()));
        }
        if (bean.getUserData() != null) {
            user.setUserData(userDataBeanToUserDataEntity(bean.getUserData()));
        }
        log.info("UserEntity -> {}", user.toString());
        return user;
    }

    public static UserDto userEntityToUserBean(User entity) {
        log.info("UserEntity -> {}", entity.toString());
        UserDto user = UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(
                        roleEntityToRoleBean(entity.getRole()))
                .userData(
                        userDataEntityToUserDataBean(entity.getUserData()))
                .build();
        log.info("UserBean -> {}", user.toString());
        return user;
    }

    public static List<UserDto> userEntityToUserBean(List<User> entity) {
        List<UserDto> userDtoList = new ArrayList<>();
        entity.forEach(item -> userDtoList.add(userEntityToUserBean(item)));
        return userDtoList;
    }

    public static Role roleBeanToRoleEntity(RoleDto bean) {
        return Role.builder()
                .id(bean.getId())
                .name(bean.getRole())
                .build();
    }

    public static RoleDto roleEntityToRoleBean(Role entity) {
        return RoleDto.builder()
                .id(entity.getId())
                .role(entity.getName())
                .build();
    }

    public static UserData userDataBeanToUserDataEntity(UserDataDto bean) {
        UserData userData = UserData.builder()
                .id(bean.getId())
                .firstName(bean.getFirstName())
                .lastName(bean.getLastName())
                .middleName(bean.getMiddleName())
                .build();
        if (Objects.nonNull(bean.getAge())) {
            userData.setAge(new Date(bean.getAge().getTime()));
        }
        return userData;
    }

    public static UserDataDto userDataEntityToUserDataBean(UserData entity) {
        UserDataDto userData = UserDataDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .build();
        if (Objects.nonNull(entity.getAge())) {
            userData.setAge(new java.util.Date(entity.getAge().getTime()));
        }
        return userData;
    }

    public static BookDto bookEntityToBookBean(Book bookEntity) {
        return BookDto.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .publisher(bookEntity.getPublisher())
                .binding(bookEntity.getBinding())
                .ageRestrictions(bookEntity.getAgeRestrictions())
                .isbn(bookEntity.getIsbn())
                .description(bookEntity.getDescription())
                .publishingYear(bookEntity.getPublishingYear())
                .build();

    }

    public static List<BookDto> bookEntityToBookBean(List<Book> listBookEntity) {
        var resultList = new ArrayList<BookDto>();
        listBookEntity.forEach(bookEntity -> resultList.add(bookEntityToBookBean(bookEntity)));
        return resultList;
    }

    public static Book bookBeanToBookEntity(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .binding(bookDto.getBinding())
                .ageRestrictions(bookDto.getAgeRestrictions())
                .isbn(bookDto.getIsbn())
                .description(bookDto.getDescription())
                .publishingYear(bookDto.getPublishingYear())
                .build();
    }

}

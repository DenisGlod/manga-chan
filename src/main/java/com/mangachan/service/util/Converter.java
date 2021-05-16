package com.mangachan.service.util;

import com.mangachan.dao.entity.Book;
import com.mangachan.dao.entity.Role;
import com.mangachan.dao.entity.User;
import com.mangachan.dao.entity.UserData;
import com.mangachan.service.bean.BookBean;
import com.mangachan.service.bean.RoleBean;
import com.mangachan.service.bean.UserBean;
import com.mangachan.service.bean.UserDataBean;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Converter {

    public static User userBeanToUserEntity(UserBean bean) {
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

    public static UserBean userEntityToUserBean(User entity) {
        log.info("UserEntity -> {}", entity.toString());
        UserBean user = UserBean.builder()
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

    public static List<UserBean> userEntityToUserBean(List<User> entity) {
        List<UserBean> userBeanList = new ArrayList<>();
        entity.forEach(item -> userBeanList.add(userEntityToUserBean(item)));
        return userBeanList;
    }

    public static Role roleBeanToRoleEntity(RoleBean bean) {
        return Role.builder()
                .id(bean.getId())
                .name(bean.getRole())
                .build();
    }

    public static RoleBean roleEntityToRoleBean(Role entity) {
        return RoleBean.builder()
                .id(entity.getId())
                .role(entity.getName())
                .build();
    }

    public static UserData userDataBeanToUserDataEntity(UserDataBean bean) {
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

    public static UserDataBean userDataEntityToUserDataBean(UserData entity) {
        UserDataBean userData = UserDataBean.builder()
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

    public static BookBean bookEntityToBookBean(Book bookEntity) {
        return BookBean.builder()
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

    public static List<BookBean> bookEntityToBookBean(List<Book> listBookEntity) {
        var resultList = new ArrayList<BookBean>();
        listBookEntity.forEach(bookEntity -> resultList.add(bookEntityToBookBean(bookEntity)));
        return resultList;
    }

    public static Book bookBeanToBookEntity(BookBean bookBean) {
        return Book.builder()
                .id(bookBean.getId())
                .name(bookBean.getName())
                .author(bookBean.getAuthor())
                .publisher(bookBean.getPublisher())
                .binding(bookBean.getBinding())
                .ageRestrictions(bookBean.getAgeRestrictions())
                .isbn(bookBean.getIsbn())
                .description(bookBean.getDescription())
                .publishingYear(bookBean.getPublishingYear())
                .build();
    }

}

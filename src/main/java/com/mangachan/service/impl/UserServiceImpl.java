package com.mangachan.service.impl;

import com.mangachan.dao.repository.UserRepository;
import com.mangachan.service.UserService;
import com.mangachan.service.bean.UserBean;
import com.mangachan.service.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserBean> getAllUser() {
        var userList = repository.findAll();
        return Converter.userEntityToUserBean(userList);
    }

    @Override
    public Optional<UserBean> findUserById(Long id) {
        var userOptional = repository.findUserById(id);
        return userOptional.map(Converter::userEntityToUserBean);
    }

    @Override
    public Optional<UserBean> login(String email, String password) {
        var userOptional = repository.findUserByEmailAndPassword(email, password);
        return userOptional.map(Converter::userEntityToUserBean);
    }

    @Override
    public UserBean save(UserBean bean) {
        var user = repository.save(Converter.userBeanToUserEntity(bean));
        return Converter.userEntityToUserBean(user);
    }

    @Override
    public Optional<UserBean> delete(UserBean bean) {
        return Optional.empty();
    }
}

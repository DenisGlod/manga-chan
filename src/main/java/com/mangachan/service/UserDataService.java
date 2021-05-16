package com.mangachan.service;

import com.mangachan.service.bean.UserDataBean;

import java.util.List;
import java.util.Optional;

public interface UserDataService {
    List<UserDataBean> getAllUserData();

    Optional<UserDataBean> findById(Long id);

    Optional<UserDataBean> save(UserDataBean bean);

    Optional<UserDataBean> delete(UserDataBean bean);
}

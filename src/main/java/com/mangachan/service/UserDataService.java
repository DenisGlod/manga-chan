package com.mangachan.service;

import com.mangachan.service.dto.UserDataDto;

import java.util.List;
import java.util.Optional;

public interface UserDataService {
    List<UserDataDto> getAllUserData();

    Optional<UserDataDto> findById(Long id);

    Optional<UserDataDto> save(UserDataDto bean);

    Optional<UserDataDto> delete(UserDataDto bean);
}

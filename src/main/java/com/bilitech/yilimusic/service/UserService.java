package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.UserCreateRequest;
import com.bilitech.yilimusic.dto.UserDto;
import com.bilitech.yilimusic.dto.UserUpdateRequest;
import com.bilitech.yilimusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;


public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);
}

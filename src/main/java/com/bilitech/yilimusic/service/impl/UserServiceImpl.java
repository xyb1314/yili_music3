package com.bilitech.yilimusic.service.impl;

import com.bilitech.yilimusic.dto.UserCreateDto;
import com.bilitech.yilimusic.dto.UserDto;
import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.enums.Gender;
import com.bilitech.yilimusic.exception.BizException;
import com.bilitech.yilimusic.exception.ExceptionType;
import com.bilitech.yilimusic.mapper.UserMapper;
import com.bilitech.yilimusic.repository.UserRepository;
import com.bilitech.yilimusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;


    UserMapper mapper; //转换时使用

    PasswordEncoder passwordEncoder ;

    @Override
    public List<UserDto> list() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());//check....

        User user = mapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(  repository.save(user) );

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()){
            throw  new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get() ;
    }


    private void checkUserName(String username){
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()){
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);

        }
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}

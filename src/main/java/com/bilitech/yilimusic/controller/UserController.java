package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.UserCreateDto;
import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.enums.Gender;
import com.bilitech.yilimusic.mapper.UserMapper;
import com.bilitech.yilimusic.repository.UserRepository;
import com.bilitech.yilimusic.service.UserService;
import com.bilitech.yilimusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    UserService userService;

    UserMapper userMapper;

    UserRepository userRepository ;

    @GetMapping("/")
    List<UserVo> list(){

        return userService.list().stream()
                .map(userMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("/")
    UserVo create(@RequestBody UserCreateDto userCreateDto){

        return userMapper.toVo(userService.create(userCreateDto));
    }




    @GetMapping("/hello")
    public String sayhello(){

//        User user = new User();
//        user.setUsername("admin");
//
//        user.setEnabled(true);
//        user.setLocked(false);
//        user.setPassword("9095155");
//        user.setGender(Gender.MALE);
//        user.setLastLoginIp("127.0.0.1");
//        User savedUser = userRepository.save(user); // repository.save
//
//        //check the result in the terminal
//        User result = userRepository.getByUsernameAndGender("admin",Gender.MALE);
//        System.out.println(result.toString());

        return "hello";
    }


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.UserCreateRequest;
import com.bilitech.yilimusic.dto.UserUpdateRequest;
import com.bilitech.yilimusic.mapper.UserMapper;
import com.bilitech.yilimusic.repository.UserRepository;
import com.bilitech.yilimusic.service.UserService;
import com.bilitech.yilimusic.vo.UserVo;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"},direction = Sort.Direction.ASC) Pageable pageable){

        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping("/")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest){

        return userMapper.toVo(userService.create(userCreateRequest));
    }


    @GetMapping("/{id}")
    UserVo get(@PathVariable String id){
        return  userMapper.toVo(userService.get(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id ,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest)
    {
        return userMapper.toVo(userService.update(id,userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        userService.delete(id);
    }


    @GetMapping("/hello")
    public String sayhello(){

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

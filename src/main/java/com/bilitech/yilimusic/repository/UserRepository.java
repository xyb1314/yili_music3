package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.enums.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


//  JpaRepository<T, ID> T是 entity 的对象类 ，string 是 primary Key 的类型
public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
    User getByUsernameAndGender(String username , Gender gender) ;
    Optional<User> findByUsername(String username) ;
    User getById(String id);

    Page <User> findAll(Pageable pageable);
}

package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//  JpaRepository<T, ID> T是 entity 的对象类 ，string 是 primary Key 的类型
public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
    User getByUsernameAndGender(String username , Gender gender) ;

}

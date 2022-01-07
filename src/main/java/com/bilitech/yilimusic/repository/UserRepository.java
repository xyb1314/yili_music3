package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
}

package com.bilitech.yilimusic.entity;

import com.bilitech.yilimusic.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity //持久层
@Data
public class User extends AbstractEntity{

    @Column(unique = true) // username is unique key
    private String username;

    private String nickname;

    @ManyToMany(fetch = FetchType.EAGER) // Lazy
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String password;

    @Enumerated(EnumType.STRING) //存储时，令其转换为string ，如果不加的话，默认存的是 enum 的 index 即 0 1 2
    private Gender gender;

    private Boolean locked; // Boolean 在数据库里 对应 的 是 tinyInt 只有 0 和 1

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime; // Date类型 对应 sql 的 datetime
}

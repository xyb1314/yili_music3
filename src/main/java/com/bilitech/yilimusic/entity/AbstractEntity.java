package com.bilitech.yilimusic.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data   // 加了这个 lombok 自动对成员变量 构造 getter and setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name="ksuid", strategy = "com.bilitech.yilimusic.utils.KsuidIdentifierGenerator")
    private String id;

    @CreationTimestamp //使用该注解可以让Hibernate在插入时针对注解的属性对应的日期类型创建默认值。
    private Date createdTime;

    @UpdateTimestamp
    private Date updatedTime;
}

package com.account.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: balance-of-account
 * @description: 用户类
 * @author: Vincent
 * @create: 2018-12-29 14:12
 **/
@Component
@Table(name = "t_user")
public class UserInfo {

    private Integer id;

    private String name;

    private Integer age;

    public UserInfo() {}

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

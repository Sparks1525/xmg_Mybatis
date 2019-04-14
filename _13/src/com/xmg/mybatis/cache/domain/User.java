package com.xmg.mybatis.cache.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("User") // 需要在mybatis-config.xml中配置扫描包的路径
public class User {

    private long id;
    private String name;
    private String email;
    private int age;
    private Date bornDate;

    public User() {
    }

    public User(String name, String email, int age, Date bornDate) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.bornDate = bornDate;
    }

    public User(int id, String name, String email, int age, Date bornDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.bornDate = bornDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", bornDate=" + bornDate +
                '}';
    }
}

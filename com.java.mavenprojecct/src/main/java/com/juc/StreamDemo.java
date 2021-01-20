package com.juc;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;


class User{
    private int id;
    private String userName;
    private int age;

    public User() {
    }

    public User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/**
 * 请按照给出数据，找出同时满足以下条件的用户，也即以下条件全部满足，
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序，只输出一个
 * 用户名字。
 */

public class StreamDemo {
    public static void main(String[] args) {
        User user1 = new User(11,"a",23);
        User user2 = new User(12,"b",24);
        User user3 = new User(13,"c",22);
        User user4 = new User(14,"d",28);
        User user5 = new User(16,"e",26);

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
        list.stream().filter(user -> {return user.getId() % 2 == 0;}).forEach(System.out::println);

    }
}

package com.company.utils;

import com.company.entity.User;

public class UserThreadLocal {

    private final static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    //向threadLocal中放东西


    public static void setUser(User user) {
        threadLocal.set(user);
    }

    //从threadlocal中获取东西
    public static User getUser() {
       return threadLocal.get();
    }

    //从threadlocal中清除
    public static void remove() {
        threadLocal.remove();
    }

}
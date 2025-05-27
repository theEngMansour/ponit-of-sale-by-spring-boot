package com.learn.service.impelement;

public class PasswordEncoder {
    public static String encodePassword(String password) {
        return password + "/+-";
    }
}

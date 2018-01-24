package com.smalaca.ebook.domain;

public class User {
    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    String login() {
        return login;
    }

    boolean hasPasswordEqualTo(String password) {
        return this.password.equals(password);
    }
}

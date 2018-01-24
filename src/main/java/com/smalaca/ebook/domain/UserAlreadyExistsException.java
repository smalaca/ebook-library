package com.smalaca.ebook.domain;

public class UserAlreadyExistsException extends RuntimeException {

    UserAlreadyExistsException(User user) {
        super("User " + user.login() + " already exists.");
    }
}

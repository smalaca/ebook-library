package com.smalaca.ebook.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAlreadyExistsExceptionTest {
    private static final String SOME_LOGIN = "scott_summers";
    private static final String SOME_PASSWORD = "x_men";

    @Test
    public void shouldCreateExceptionWithValidMessage() {
        UserAlreadyExistsException exception = new UserAlreadyExistsException(new User(SOME_LOGIN, SOME_PASSWORD));

        assertEquals("User " + SOME_LOGIN + " already exists.", exception.getMessage());
    }
}

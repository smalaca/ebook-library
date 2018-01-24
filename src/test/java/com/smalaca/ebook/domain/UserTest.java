package com.smalaca.ebook.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private static final String SOME_LOGIN = "jean_grey";
    private static final String SOME_PASSWORD = "zxcvbn";
    private static final String DIFFERENT_PASSWORD = "qwerty";

    @Test
    public void shouldRecognizeWhenPasswordIsDiffernt() {
        assertFalse(givenUser().hasPasswordEqualTo(DIFFERENT_PASSWORD));
    }

    @Test
    public void shouldRecognizeWhenPasswordIsEqual() {
        assertTrue(givenUser().hasPasswordEqualTo(SOME_PASSWORD));
    }

    private User givenUser() {
        return new User(SOME_LOGIN, SOME_PASSWORD);
    }
}

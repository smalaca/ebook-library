package com.smalaca.ebook.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStorageTest {
    private static final String SOME_LOGIN = "logan";
    private static final String ANOTHER_LOGIN = "peterparker";
    private static final String SOME_PASSWORD = "password";
    private static final String ANOTHER_PASSWORD = "admin";

    private final UserStorage userStorage = new UserStorage();

    @Test
    public void shouldRecognizeWhenUserIsNotPresentIsStore() {
        assertFalse(userStorage.exists(SOME_LOGIN));
    }

    @Test
    public void shouldRecognizeWhenUserIsPresentIsStore() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));

        assertTrue(userStorage.exists(SOME_LOGIN));
    }

    @Test
    public void shouldBePossibleToAddMultipleUsers() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));
        userStorage.add(new User(ANOTHER_LOGIN, SOME_PASSWORD));

        assertTrue(userStorage.exists(SOME_LOGIN));
        assertTrue(userStorage.exists(ANOTHER_LOGIN));
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void shouldThrowExceptionWhenUserWithTheSameLoginIsAddedAnotherTime() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));
    }

    @Test
    public void shouldRecognizeWhenThereIsNoUserWithGivenLogin() {
        boolean result = userStorage.exists(SOME_LOGIN, SOME_PASSWORD);

        assertFalse(result);
    }

    @Test
    public void shouldRecognizeWhenThereIsNoUserWithGivenPassword() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));

        boolean result = userStorage.exists(SOME_LOGIN, ANOTHER_PASSWORD);

        assertFalse(result);
    }

    @Test
    public void shouldRecognizeWhenUserExists() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));

        boolean result = userStorage.exists(SOME_LOGIN, SOME_PASSWORD);

        assertTrue(result);
    }
}

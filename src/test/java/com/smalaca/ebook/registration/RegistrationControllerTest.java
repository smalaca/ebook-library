package com.smalaca.ebook.registration;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.User;
import com.smalaca.ebook.domain.UserStorage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {
    private static final String VALID_LOGIN = "logan";
    private static final String VALID_PASSWORD = "123456";
    private static final String TOO_SHORT_PASSWORD = "12";

    private final UserStorage userStorage = new UserStorage();
    private final RegistrationController registrationController = new RegistrationController(userStorage);

    @Test
    public void shouldRegisterNewUser() {
        Response result = registrationController.register(VALID_LOGIN, VALID_PASSWORD);

        assertTrue(result.isSuccess());
        assertTrue(userStorage.exists(VALID_LOGIN));
    }

    @Test
    public void shouldFailIfPasswordIsTooShort() {
        Response result = registrationController.register(VALID_LOGIN, TOO_SHORT_PASSWORD);

        assertFalse(result.isSuccess());
        assertEquals("Password too short", result.getMessage());
        assertFalse(userStorage.exists(VALID_LOGIN));
    }

    @Test
    public void shouldFailWhenUserAlreadyExists() {
        userStorage.add(new User(VALID_LOGIN, VALID_PASSWORD));

        Response result = registrationController.register(VALID_LOGIN, VALID_PASSWORD);

        assertFalse(result.isSuccess());
        assertEquals("User already exists", result.getMessage());
    }
}

package com.smalaca.ebook.login;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.User;
import com.smalaca.ebook.domain.UserStorage;
import com.smalaca.ebook.registration.RegistrationController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginControllerTest {
    private static final String SOME_LOGIN = "charles_xavier";
    private static final String ANOTHER_LOGIN = "mary_jean_watson";
    private static final String SOME_PASSWORD = "qwerty";
    private static final String ANOTHER_PASSWORD = "1qaz2wsx";
    private static final String EXPECTED_MESSAGE = "Login or password invalid.";

    private final UserStorage userStorage = new UserStorage();
    private final LoginController loginController = new LoginController(userStorage);

    @Before
    public void initUserStorage() {
        userStorage.add(new User(SOME_LOGIN, SOME_PASSWORD));
    }

    @Test
    public void shouldNotLoginWhenUserDoesNotExist() {
        Response response = loginController.login(ANOTHER_LOGIN, SOME_PASSWORD);

        assertFalse(response.isSuccess());
        assertEquals(EXPECTED_MESSAGE, response.getMessage());
    }

    @Test
    public void shouldNotLoginWhenPasswordIsIncorrect() {
        Response response = loginController.login(SOME_LOGIN, ANOTHER_PASSWORD);

        assertFalse(response.isSuccess());
        assertEquals(EXPECTED_MESSAGE, response.getMessage());
    }

    @Test
    public void shouldLoginUser() {
        Response response = loginController.login(SOME_LOGIN, SOME_PASSWORD);

        assertTrue(response.isSuccess());
    }
}

package com.smalaca.ebook.login;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.UserStorage;

public class LoginController {
    private static final String INVALID_AUTHENTICATION_MESSAGE = "Login or password invalid.";

    private final UserStorage userStorage;

    public LoginController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response login(String login, String password) {
        if (userStorage.exists(login, password)) {
            return Response.aSuccessfuleResponse();
        }

        return Response.aFailureResponse(INVALID_AUTHENTICATION_MESSAGE);
    }
}

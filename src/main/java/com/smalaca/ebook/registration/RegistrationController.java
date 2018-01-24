package com.smalaca.ebook.registration;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.domain.User;
import com.smalaca.ebook.domain.UserStorage;

public class RegistrationController {
    private static final int REQUIRED_PASSWORD_LENGTH = 4;

    private final UserStorage userStorage;

    public RegistrationController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public Response register(String login, String password) {
        if (isTooShort(password)) {
            return Response.aFailureResponse("Password too short");
        }

        if (userStorage.exists(login)) {
            return Response.aFailureResponse("User already exists");
        }

        userStorage.add(new User(login, password));

        return Response.aSuccessfuleResponse();
    }

    private boolean isTooShort(String password) {
        return password.length() < REQUIRED_PASSWORD_LENGTH;
    }
}

package com.smalaca.ebook.domain;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private final Map<String, User> users = new HashMap<>();

    public void add(User user) {
        if (exists(user.login())) {
            throw new UserAlreadyExistsException(user);
        }

        users.put(user.login(), user);
    }

    public boolean exists(String login) {
        return users.containsKey(login);
    }
}

package com.smalaca.ebook.registration;

import com.smalaca.ebook.communication.Response;
import com.smalaca.ebook.view.SystemInterface;

public class RegistrationView {
    private final RegistrationController controller;
    private final SystemInterface systemInterface;

    public RegistrationView(RegistrationController registrationController, SystemInterface systemInterface) {
        controller = registrationController;
        this.systemInterface = systemInterface;
    }

    public void show() {
        systemInterface.display("Podaj login:");
        String login = systemInterface.readInformation();
        systemInterface.display("Podaj hasło:");
        String password = systemInterface.readInformation();

        Response response = controller.register(login, password);

        if (response.isSuccess()) {
            systemInterface.display("Udało się zarejestrować użytkownia " + login + ".");
        } else {
            systemInterface.display("Rejestracja się nie powiodła.");
            systemInterface.display(response.getMessage());
        }
    }
}

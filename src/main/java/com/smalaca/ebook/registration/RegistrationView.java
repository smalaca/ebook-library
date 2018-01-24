package com.smalaca.ebook.registration;

import com.smalaca.ebook.communication.Response;

import java.util.Scanner;

public class RegistrationView {
    private final Scanner scanner;
    private final RegistrationController controller;

    public RegistrationView(Scanner scanner, RegistrationController registrationController) {
        this.scanner = scanner;
        controller = registrationController;
    }

    public void show() {
        System.out.println("Podaj login:");
        String login = scanner.next();
        System.out.println("Podaj hasło:");
        String password = scanner.next();

        Response response = controller.register(login, password);

        if (response.isSuccess()) {
            System.out.println("Udało się zarejestrować użytkownia " + login + ".");
        } else {
            System.out.println("Rejestracja się nie powiodła.");
            System.out.println(response.getMessage());
        }
    }
}

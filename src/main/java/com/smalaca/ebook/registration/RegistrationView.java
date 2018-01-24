package com.smalaca.ebook.registration;

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
    }
}

package com.smalaca.ebook.registration;

import java.util.Scanner;

public class RegistrationView {
    private final Scanner scanner;

    public RegistrationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("Podaj login:");
        String login = scanner.next();
        System.out.println("Podaj hasło:");
        String password = scanner.next();
    }
}

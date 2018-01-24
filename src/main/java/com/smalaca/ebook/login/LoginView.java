package com.smalaca.ebook.login;

import java.util.Scanner;

public class LoginView {
    private final Scanner scanner;

    public LoginView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("Podaj login:");
        String login = scanner.next();
        System.out.println("Podaj hasło:");
        String password = scanner.next();
    }
}

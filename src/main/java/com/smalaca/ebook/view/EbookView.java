package com.smalaca.ebook.view;

import com.smalaca.ebook.login.LoginView;
import com.smalaca.ebook.registration.RegistrationView;

import java.util.Scanner;

public class EbookView {
    private static final int EVERYTHING_WAS_FINE = 0;

    private final Scanner scanner;
    private final MainManu mainManu;
    private final RegistrationView registrationView;
    private final LoginView loginView;

    public EbookView() {
        scanner = new Scanner(System.in);
        mainManu = new MainManu();
        registrationView = new RegistrationView(scanner);
        loginView = new LoginView(scanner);
    }

    public void show() {
        mainManu.show();

        int option = scanner.nextInt();

        if (option == 1) {
            loginView.show();
            show();
        } else if (option == 2) {
            registrationView.show();
            show();
        } else if (option == 3) {
            System.exit(EVERYTHING_WAS_FINE);
        } else {
            System.out.println("Niepoprawna wartość, wybierz ponownie.");
            show();
        }
    }
}

package com.smalaca.ebook.view;

import java.util.Scanner;

public class CliSystemInterface implements SystemInterface {
    private final Scanner scanner;

    public CliSystemInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String readInformation() {
        return scanner.next();
    }
}

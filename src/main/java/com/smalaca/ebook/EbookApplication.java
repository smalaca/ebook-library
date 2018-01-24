package com.smalaca.ebook;

import com.smalaca.ebook.domain.UserStorage;
import com.smalaca.ebook.view.EbookView;

import java.util.Scanner;

public class EbookApplication {
    public static void main(String[] args) {
        new EbookView(new Scanner(System.in), new UserStorage()).show();
    }
}

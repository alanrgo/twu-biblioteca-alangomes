package com.twu.biblioteca.services;

import java.util.Scanner;

public class MenuService {

    private Scanner inputObj;
    private int numberOptions = 1;

    public MenuService() {
        this.inputObj = new Scanner(System.in);
    }

    public MenuService(Scanner scanner) {
        this.inputObj = scanner;
    }

    public void displayMenu(){
        System.out.print("How can we help you?\n");
        System.out.print("1 - List of books.\n");
    }

    private boolean isValid(int option) {
        if ( option > 0 && option <= numberOptions ) {
            return true;
        }
        System.out.print("This is not a valid option.\n");
        return false;
    }

    public int getUserOption() {
        int option;
        do {
            option = inputObj.nextInt();
        } while ( !isValid(option));
        return option;
    }
}

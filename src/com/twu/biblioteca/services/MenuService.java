package com.twu.biblioteca.services;

import com.twu.biblioteca.models.MenuOption;

import java.util.Scanner;

public class MenuService {

    private Scanner inputObj;
    private int numberOptions = 2;

    public MenuService() {
        this.inputObj = new Scanner(System.in);
    }

    public MenuService(Scanner scanner) {
        this.inputObj = scanner;
    }

    public void displayMenu(){
        System.out.print("\nHow can we help you?\n");
        System.out.print("1 - List of books.\n");
        System.out.print("2 - Quit Application.\n");
    }

    private boolean isValid(int option) {
        if ( option > 0 && option <= numberOptions ) {
            return true;
        }
        System.out.print("Please select a valid option!\n");
        return false;
    }

    public MenuOption getUserOption() {
        int option;
        do {
            option = inputObj.nextInt();
        } while ( !isValid(option));
        return MenuOption.values()[option];
    }
}

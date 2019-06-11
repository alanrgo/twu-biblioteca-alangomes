package com.twu.biblioteca.services;

import com.twu.biblioteca.models.MenuOption;

import java.util.Scanner;

public class MenuService {

    private Scanner inputObj;
    private int numberOptions = 4;

    public MenuService() {
        this.inputObj = new Scanner(System.in);
    }

    public MenuService(Scanner scanner) {
        this.inputObj = scanner;
    }

    public void displayMenu(){
        System.out.print(Content.STRINGIFIED_MENU);
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

    public int getBookIndex() {
        return inputObj.nextInt();
    }

    public void displayCheckoutInterface() {
        System.out.print(Content.CHECKOUT_SCOPE + Content.CHECKOUT_INPUT_MESSAGE);
    }

    public void displayCheckoutSuccessMessage() {
        System.out.print(Content.CHECKOUT_SUCCESS);
    }

    public void displayCheckoutFailureMessage() {
        System.out.print(Content.CHECKOUT_FAILURE);
    }
}

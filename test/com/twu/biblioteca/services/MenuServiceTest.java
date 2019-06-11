package com.twu.biblioteca.services;

import com.twu.biblioteca.models.MenuOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MenuServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private String stringfiedMenu = Content.STRINGIFIED_MENU;
    private String errorMessage = "Please select a valid option!\n";


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testIfItIsDisplayingTheRightMenu() {
        MenuService menuService = new MenuService();
        menuService.displayMenu();

        assertEquals(stringfiedMenu, outContent.toString());
    }

    @Test
    public void testIfListBookOptionIsWorking() {
        String listBookInput = "1\n";
        Scanner scanner = new Scanner(listBookInput);
        MenuService menuService = new MenuService(scanner);
        MenuOption option = menuService.getUserOption();

        assertEquals(MenuOption.LIST_BOOKS, option);
    }

    @Test
    public void testErrorMessageForInvalidOption() {
        String listBookInput = "50\n2\n";
        Scanner scanner = new Scanner(listBookInput);
        MenuService menuService = new MenuService(scanner);

        menuService.getUserOption();
        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    public void testIfRightOptionIsReturnedAfterOneTrial() {
        String listBookInput = "50\n1\n";
        Scanner scanner = new Scanner(listBookInput);
        MenuService menuService = new MenuService(scanner);

        MenuOption option = menuService.getUserOption();
        assertEquals(MenuOption.LIST_BOOKS, option);
    }

    @Test
    public void testIfBookIndexIsReturned() {
        String checkoutOption = "2\n";
        String bookIndexInput = "1\n";
        String quitOption = "3\n";
        String userOverallInput = checkoutOption + bookIndexInput + quitOption;
        Scanner scanner = new Scanner(userOverallInput);
        MenuService menuService = new MenuService(scanner);

        menuService.getUserOption();
        int bookIndex = menuService.getBookIndex();
        assertEquals(1, bookIndex);
    }


}

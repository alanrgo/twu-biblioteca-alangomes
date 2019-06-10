package com.twu.biblioteca.services;

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

    private String stringfiedMenu = "How can we help you?\n1 - List of books.\n";
    private String errorMessage = "This is not a valid option.\n";


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
        int option = menuService.getUserOption();

        assertEquals(1, option);
    }

    @Test
    public void testErrorMessageForInvalidOption() {
        String listBookInput = "50\n1\n";
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

        int option = menuService.getUserOption();
        assertEquals(1, option);
    }
}

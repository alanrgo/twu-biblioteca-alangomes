package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.MenuOption;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;

import java.util.List;
import java.util.ListIterator;

public class BibliotecaApp {

    private BookService bookService;
    private MenuService menuService;

    public BibliotecaApp() {
        this.bookService = new BookService();
        this.menuService = new MenuService();
    }

    public BibliotecaApp(BookService bookService, MenuService menuService) {
        this.bookService = bookService;
        this.menuService = menuService;
    }


    public void run() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        MenuOption option;
        do {
            this.menuService.displayMenu();
            option = this.menuService.getUserOption();
            if( option == MenuOption.LIST_BOOKS ) {
                this.bookService.printBookList(this.bookService.getBookList());
            }
        } while ( option != MenuOption.QUIT);

        System.out.print("Quitting the application. Hope to see you soon! ;D\n");
    }


    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }


}

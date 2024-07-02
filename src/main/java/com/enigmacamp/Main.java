package com.enigmacamp;

import com.enigmacamp.menu.MenuTodo;
import com.enigmacamp.menu.MenuUser;

public class Main {

    public static void main(String[] args) {
        MenuUser menuUser = new MenuUser();
        MenuTodo menuTodo = new MenuTodo();
        boolean check = menuUser.displayMenu();

        if (check) {
            menuTodo.displayMenu();
        }





    }
}
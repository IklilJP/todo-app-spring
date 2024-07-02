package com.enigmacamp.menu;


import com.enigmacamp.service.user.UserServiceImp;

import java.util.Scanner;

public class MenuUser {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserServiceImp userServiceImp = new UserServiceImp();

    public boolean displayMenu() {
        boolean check;
        System.out.println("1. Daftar");
        System.out.println("2. Login");
        System.out.println("3. Keluar");
        check = menuUser();
        return check;
    }

    public boolean menuUser() {
        String menu;
        boolean check = false;
        do {
            System.out.println("Pilih menu : ");
            menu = sc.nextLine();

            switch (menu) {
                case "1":
                    System.out.println("Daftar");
                    forumAddUser();
                    break;
                case "2":
                    System.out.println("Login");
                    check = forumlogin();
                    break;
                case "3":
                    System.out.println("Keluar");
                    return check;
                default:
                    System.out.println("pilihan tidak tersedia tolong pilih kembali ");
            }
        } while (!menu.equals("3") && !check);
        return check;
    }


    public static void forumAddUser() {
        String username, password;
        do {
            System.out.println("masukan username : ");
            username = sc.nextLine();
            username = username.trim();
            if (username.isBlank() || username.isEmpty()) {
                System.out.println("Username Tidak boleh kosong ! ");
            }
        } while (username.isBlank() || username.isEmpty());
        do {
            System.out.println("masukan password : ");
            password = sc.nextLine();
            password = password.trim();
            if (password.isBlank() || password.isEmpty()) {
                System.out.println("Password Tidak boleh kosong ! ");
            }
        } while (password.isBlank() || password.isEmpty());
        userServiceImp.addUser(username, password);
    }

    public static boolean forumlogin() {
        System.out.println("-".repeat(50));
        System.out.println("Selamat datang di Login ");
        System.out.println("Tolong masukan username dan password");
        System.out.println("-".repeat(50));
        System.out.println("Username : ");
        String username = sc.nextLine();
        System.out.println("Password : ");
        String password = sc.nextLine();
        boolean check = userServiceImp.loginUser(username, password);
        if (check) {
            System.out.println("Login Berhasil");
            return check;
        } else {
            System.out.println("Login gagal");
            return check;
        }

    }


}

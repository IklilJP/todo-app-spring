package com.enigmacamp.menu;


import com.enigmacamp.service.todo.TodoServiceImp;

import java.util.Scanner;

public class MenuTodo {
    private static final Scanner sc = new Scanner(System.in);
    private static final TodoServiceImp todoServiceImp = new TodoServiceImp();


    public void displayMenu() {
        System.out.println("-".repeat(50));
        System.out.println("Selamat Datang di menu ToDo App");
        System.out.println("-".repeat(50));
        System.out.println("1. Add Task");
        System.out.println("2. View Task");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("-".repeat(50));
        System.out.println("masukan pilihan : ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                System.out.println("-".repeat(50));
                System.out.println("Tambah Task");
                System.out.println("-".repeat(50));
                forumAdd();
                displayMenu();
            case "2":
                System.out.println("-".repeat(50));
                System.out.println("Tampilkan Task");
                System.out.println("-".repeat(50));
                todoServiceImp.showTodo();
                displayMenu();
            case "3":
                System.out.println("-".repeat(50));
                System.out.println("Edit Task");
                System.out.println("-".repeat(50));
                forumedit();
                displayMenu();
            case "4":
                System.out.println("-".repeat(50));
                System.out.println("Delete Task");
                System.out.println("-".repeat(50));
                forumDelete();
                displayMenu();
            case "5":
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Invalid choice");
                displayMenu();
        }
    }

    public static void forumAdd() {
        String todo_name, priority, descripsion, is_active;

        do {
            System.out.println("masukan todo name : ");
            todo_name = sc.nextLine();
            todo_name = todo_name.trim();
            if (todo_name.isBlank() || todo_name.isEmpty()) {
                System.out.println("Todo Name Tidak boleh kosong ! ");
            }
        } while (todo_name.isBlank() || todo_name.isEmpty());

        do {
            System.out.println("priority (high/medium/low)");
            System.out.println("masukan priority : ");
            priority = sc.nextLine();
            priority = priority.toLowerCase();
            if (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
                System.out.println("Priority Tidak Valid");
            }
        } while (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low"));

        System.out.println("masukan descripsion : ");
        descripsion = sc.nextLine();
        descripsion = descripsion.trim();

        do {
            System.out.println("apakah aktif (y/n) : ");
            is_active = sc.nextLine();
            if (is_active.equals("y")) {
                is_active = "active";
            } else if (is_active.equals("n")) {
                is_active = "inactive";
            }
            if (!is_active.equals("active") && !is_active.equals("inactive")) {
                System.out.println("Status Tidak Valid");
            }
        } while (!is_active.equals("active") && !is_active.equals("inactive"));

        todoServiceImp.addTodo(todo_name, priority, descripsion, is_active);
    }

    public static void forumDelete() {
        String id;
        System.out.println("Masukan id yang ingin di hapus : ");
        id = sc.nextLine();
        todoServiceImp.deleteTodo(Integer.parseInt(id));
    }

    public static void forumedit() {
        String id, todo_name, priority, descripsion, is_active;
        System.out.println("Masukan id yang ingin di edit : ");
        id = sc.nextLine();

        do {
            System.out.println("masukan todo name : ");
            todo_name = sc.nextLine();
            todo_name = todo_name.trim();
            if (todo_name.isBlank() || todo_name.isEmpty()) {
                System.out.println("Todo Name Tidak boleh kosong ! ");
            }
        } while (todo_name.isBlank() || todo_name.isEmpty());

        do {
            System.out.println("priority (high/medium/low)");
            System.out.println("masukan priority : ");
            priority = sc.nextLine();
            priority = priority.toLowerCase();
            if (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
                System.out.println("Priority Tidak Valid");
            }
        } while (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low"));

        System.out.println("masukan descripsion : ");
        descripsion = sc.nextLine();
        descripsion = descripsion.trim();

        do {
            System.out.println("apakah aktif (y/n) : ");
            is_active = sc.nextLine();
            if (is_active.equals("y")) {
                is_active = "active";
            } else if (is_active.equals("n")) {
                is_active = "inactive";
            }
            if (!is_active.equals("active") && !is_active.equals("inactive")) {
                System.out.println("Status Tidak Valid");
            }
        } while (!is_active.equals("active") && !is_active.equals("inactive"));

        todoServiceImp.editTodo(Integer.parseInt(id), todo_name, priority, descripsion, is_active);
    }

}



package com.enigmacamp.service;

import com.enigmacamp.repository.todo.TodoRepository;

public class TodoService {
    TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void addTodo(String todoName, String priority, String description, String isActive) {
        todoRepository.addTodo(todoName, priority, description, isActive);
    }

    public void editTodo(int id, String todoName, String priority, String description, String isActive) {
        todoRepository.editTodo(id, todoName, priority, description, isActive);
    }

    public void deleteTodo(int id) {
        todoRepository.deleteTodo(id);
    }

    public void showTodo() {
        todoRepository.showTodo();
    }
}

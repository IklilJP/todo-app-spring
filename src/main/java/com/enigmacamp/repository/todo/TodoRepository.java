package com.enigmacamp.repository.todo;

public interface TodoRepository {
    public void showTodo();

    public void addTodo(String todoName, String priority, String description, String isActive);

    public void editTodo(int id, String todoName, String priority, String description, String isActive);

    public void deleteTodo(int id);
}

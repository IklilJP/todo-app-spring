package com.enigmacamp.service.user;

public interface UserService {
    public void addUser(String username, String password);

    public boolean loginUser(String username, String password);
}
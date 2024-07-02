package com.enigmacamp.repository.user;

public interface UserRepository {
    public void addUser(String username, String password);

    public boolean loginUser(String username, String password);
}

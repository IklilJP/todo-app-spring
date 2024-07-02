package com.enigmacamp.service;

import com.enigmacamp.repository.user.UserRepository;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String username, String password) {
        userRepository.addUser(username, password);
    }

    public boolean loginUser(String username, String password) {
        return userRepository.loginUser(username, password);
    }

}

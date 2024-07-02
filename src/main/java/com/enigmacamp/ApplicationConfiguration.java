package com.enigmacamp;

import com.enigmacamp.repository.todo.TodoRepository;
import com.enigmacamp.repository.user.UserRepository;
import com.enigmacamp.service.TodoService;
import com.enigmacamp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.enigmacamp.repository", "com.enigmacamp.service"})
public class ApplicationConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public TodoService todoService(TodoRepository todoRepository) {
        return new TodoService(todoRepository);
    }

}

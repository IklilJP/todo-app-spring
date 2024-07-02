package com.enigmacamp.service.user;

import com.enigmacamp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserServiceImp implements UserService {
    private static final EntityManagerFactory enf = Persistence.createEntityManagerFactory("todo-persistence");
    private static final EntityManager em = enf.createEntityManager();
    private static final Scanner sc = new Scanner(System.in);
    @Override
    public void addUser(String username, String password) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO m_user (user_name, password) VALUES (?, ?)")
                .setParameter(1, username)
                .setParameter(2, password)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public boolean loginUser(String username, String password) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> users = query.getResultList();

        return !users.isEmpty();
    }


}

package com.enigmacamp.repository.todo;

import com.enigmacamp.entity.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TodoRepositoryImp implements TodoRepository {
    private static final EntityManagerFactory enf = Persistence.createEntityManagerFactory("todo-persistence");
//    private static final EntityManager em = enf.createEntityManager();

    @Override
    public void showTodo() {
        EntityManager em = enf.createEntityManager();
        int i = 1;
        TypedQuery<Todo> query = em.createQuery("SELECT t FROM Todo t", Todo.class);
        System.out.println("todo list");
        List<Todo> todos = null;
        todos = query.getResultList();
        for (Todo todo : todos) {
            System.out.println("-".repeat(50));
            System.out.println("NO : " + i);
            System.out.println("ID : " + todo.getId());
            System.out.println("Todo Name : " + todo.getTodoName());
            System.out.println("Priority : " + todo.getPriority());
            System.out.println("Description : " + todo.getDescription());
            System.out.println("Is Active : " + todo.getIsActive());
            System.out.println("-".repeat(50));
            i++;
        }
        em.close();
    }

    @Override
    public void addTodo(String todoName, String priority, String description, String isActive) {
        EntityManager em = enf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO todo (todo_name, priority, descripsion, is_active, create_date) VALUES (?, ?, ?, ?, NOW())")
                .setParameter(1, todoName)
                .setParameter(2, priority)
                .setParameter(3, description)
                .setParameter(4, isActive)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();


    }

    @Override
    public void editTodo(int id, String todoName, String priority, String description, String isActive) {
        EntityManager em = enf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Todo t SET t.todoName = :todoName, t.priority = :priority, t.description = :description, t.isActive = :isActive , t.editeDate = :editeDate WHERE t.id = :id")
                .setParameter("todoName", todoName)
                .setParameter("priority", priority)
                .setParameter("description", description)
                .setParameter("isActive", isActive)
                .setParameter("editeDate", new Date())
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void deleteTodo(int id) {
        EntityManager em = enf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Todo t WHERE t.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}

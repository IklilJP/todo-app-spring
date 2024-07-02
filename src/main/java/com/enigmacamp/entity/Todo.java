package com.enigmacamp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "todo_name",nullable = false )
    private String todoName;

    @Column(name = "priority", nullable = false, columnDefinition = "text CHECK (priority::text = ANY (ARRAY['low'::character varying, 'medium'::character varying, 'high'::character varying]::text[]))")
    private String priority;

    @Column(name = "descripsion")
    private String description;

    @Column(name = "is_active", nullable = false, columnDefinition = "text CHECK (is_active::text = ANY (ARRAY['active'::character varying, 'inactive'::character varying]::text[]))")
    private String isActive;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "edite_date")
    private Date editeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditeDate() {
        return editeDate;
    }

    public void setEditeDate(Date editeDate) {
        this.editeDate = editeDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todoName='" + todoName + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", isActive='" + isActive + '\'' +
                ", createDate=" + createDate +
                ", editeDate=" + editeDate +
                '}';
    }
}

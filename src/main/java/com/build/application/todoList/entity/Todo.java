package com.build.application.todoList.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    @Size(min = 10, message = "Enter at least 10 charactets")
    private String description;
    private LocalDate targetDate;
    private boolean isCompleted;

    public Todo(){
        
    };
    public Todo(String username, String description, LocalDate targetDate, boolean isCompleted) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isCompleted = isCompleted;
    }

    public long getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getTargetDate(){
        return this.targetDate;
    }

    public void setTargetDate(LocalDate targetDate){
        this.targetDate = targetDate;
    }

    public boolean getIsCompleted(){
        return this.isCompleted;
    }
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", isCompleted=" + isCompleted + "]";
    }

}

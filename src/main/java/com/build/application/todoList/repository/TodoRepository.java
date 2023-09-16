package com.build.application.todoList.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.build.application.todoList.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

    public List<Todo> findByUsername(String username);
}

package com.build.application.todoList.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.build.application.todoList.entity.Todo;
import com.build.application.todoList.repository.TodoRepository;


@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static{
        todos.add(new Todo("giza", "learn spring boot", LocalDate.now().plusMonths(3), false));
        todos.add(new Todo("giza", "learn angular", LocalDate.now().plusMonths(2), false));
    }

    public List<Todo> findTodosByUserName(String username){
        return todoRepository.findByUsername(username);
        // Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        // List<Todo> listFromH2 = todoRepository.findAll();
        // return listFromH2.stream().filter(predicate).toList();
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean isCompleted){
        Todo todo = new Todo(username, description, targetDate, isCompleted);
        todoRepository.save(todo);
    }
    public void deleteById(int id){
         todoRepository.deleteById(id);
        // Predicate<? super Todo> predicate = todo-> todo.getId() == id;
        // todos.removeIf(predicate);
        //todos.forEach(todo->{if(todo.getId()==id) todos.remove(todo); });
        // List<Todo> listFromH2 = todoRepository.findAll();
        // Todo todoTobeDeleted = listFromH2.stream().filter(predicate).findFirst().get();
        // todoRepository.delete(todoTobeDeleted);

    }

    public Todo findById(long id){
        return todoRepository.findById((int) id).get(); // returns an optional
        // Predicate<? super Todo> predicate = todo-> todo.getId() == id;
        // List<Todo> listFromH2 = todoRepository.findAll();
        // return listFromH2.stream().filter(predicate).findFirst().get();
        //return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo updatedTodo, long id){
        //Predicate<? super Todo> predicate = todo-> todo.getId() == updatedTodo.getId();
        Todo todoToBeUpdated = findById(id);
        if(todoToBeUpdated == null) return;
        todoRepository.delete(todoToBeUpdated);
        updatedTodo.setUsername(getLoggedInUser());
        todoRepository.save(updatedTodo);
        // todoToBeUpdated.setDescription(updatedTodo.getDescription());
        // todoToBeUpdated.setIsCompleted(updatedTodo.getIsCompleted());
        // todoToBeUpdated.setTargetDate(updatedTodo.getTargetDate());
        
    }
      private String getLoggedInUser(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

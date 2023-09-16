package com.build.application.todoList.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.build.application.todoList.entity.Todo;
import com.build.application.todoList.service.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoController {

    private TodoService todoService;

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @RequestMapping("/show-todos")
    public String getTodos(ModelMap modelMap){
        List<Todo> todos = todoService.findTodosByUserName(getLoggedInUser());
        modelMap.put("todos", todos);
        return "listTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String viewAddTodoPage(ModelMap model){
        String username = getLoggedInUser();
		Todo todo = new Todo(username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        logger.debug(">> addTodo");
        if(result.hasErrors()){
            return "todo";
        }
        logger.debug("descripton : {}" );
        todoService.addTodo(getLoggedInUser() , todo.getDescription(), todo.getTargetDate(), todo.getIsCompleted());
        return "redirect:show-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap map){
        Todo todo = todoService.findById(id);
        //map.put("todo", todo);
        map.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoDetails(ModelMap modelMap, @Valid Todo todo, BindingResult result, @RequestParam long id){
        logger.debug(">> update-todo");

        if(result.hasErrors()){
            return "todo";
        }
        logger.debug("descripton : {}" );
        todoService.updateTodo(todo,id);
        return "redirect:show-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:show-todos";
    }


    private String getLoggedInUser(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    
}

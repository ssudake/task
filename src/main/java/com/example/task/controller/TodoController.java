package com.example.task.controller;

import com.example.task.entity.TodoItem;
import com.example.task.pojo.TodoBean;
import com.example.task.repository.TodoRepository;
import com.example.task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;


    //GET All TodoItems
    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    //GET ById
    @GetMapping(value = "/{id}")
    public TodoItem getById(@PathVariable long id) {
        return todoRepository.findById(id);

    }

    @GetMapping(value = "/user/{userId}")
    public List<TodoItem> getByUserId(@PathVariable long userId) {
        return todoRepository.findAllByUserId(userId);
    }

    //CREATION
    @PostMapping(value = "/add/{userId}")
    public TodoItem create(@PathVariable long userId, @RequestBody TodoBean todoBean) throws ParseException {
        TodoItem todoItem = new TodoItem();
        todoItem.setUserId(userId);
        todoService.setTodoItemDetails(todoBean, todoItem);
        return todoRepository.save(todoItem);
    }

    //UPDATE
    @PutMapping("/update")
    public TodoItem update(@RequestBody TodoBean todoBean) throws ParseException {
        TodoItem todoItem = todoRepository.findById(todoBean.getId());
        todoService.setTodoItemDetails(todoBean, todoItem);
        return todoRepository.save(todoItem);
    }

    //DELETE
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable long id) {
        todoRepository.deleteById(id);
    }


}

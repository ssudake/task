package com.example.task.controller;

import com.example.task.entity.TodoItem;
import com.example.task.repository.TodoRepository;
import com.example.task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public TodoItem create(@RequestBody TodoItem todoBean) {
        return todoRepository.save(todoBean);
    }

    //UPDATE
    @PutMapping()
    public TodoItem update(@RequestBody TodoItem updatedTodoItem) {
        TodoItem todoItem = todoRepository.findById(updatedTodoItem.getId());
        todoItem.setId(updatedTodoItem.getId());
        todoItem.setPriority(updatedTodoItem.getPriority());
        todoItem.setText(updatedTodoItem.getText());
        todoItem.setScheduledAt(updatedTodoItem.getScheduledAt());
        todoItem.setCompleted(updatedTodoItem.isCompleted());
        return todoRepository.save(todoItem);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        todoRepository.deleteById(id);
    }


}

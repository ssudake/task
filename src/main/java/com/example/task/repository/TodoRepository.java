package com.example.task.repository;

import com.example.task.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<TodoItem, Long> {

    public TodoItem findById(long id);

    List<TodoItem> findAllByUserId(long userId);
}

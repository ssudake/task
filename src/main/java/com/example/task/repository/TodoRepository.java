package com.example.task.repository;

import com.example.task.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {

    public TodoItem findById(long id);

    List<TodoItem> findAllByUserId(long userId);
}

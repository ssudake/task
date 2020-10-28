package com.example.task.service;

import com.example.task.entity.TodoItem;
import com.example.task.pojo.TodoBean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class TodoService {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String STATUS_TRUE = "true";

    public void setTodoItemDetails(TodoBean todoBean, TodoItem todoItem) throws ParseException {
        todoItem.setId(todoBean.getId());
        todoItem.setText(todoBean.getText());
        todoItem.setScheduledAt(new SimpleDateFormat(DATE_FORMAT).parse(todoBean.getScheduledDate()));
        todoItem.setPriority(Integer.parseInt(todoBean.getPriority()));
        todoItem.setCompleted(STATUS_TRUE.equals(todoBean.getStatus()));
    }

}

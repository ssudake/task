package com.example.task.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TODOBean {
    private long id;
    private String text;
    private String status;
    private String scheduledDate;
    private String priority;
}

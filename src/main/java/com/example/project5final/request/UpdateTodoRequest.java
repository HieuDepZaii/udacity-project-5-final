package com.example.project5final.request;

import lombok.Data;

@Data
public class UpdateTodoRequest {
    private String title;
    private String description;
    private Boolean completed;
}

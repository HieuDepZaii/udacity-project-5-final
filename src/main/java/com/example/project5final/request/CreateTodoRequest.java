package com.example.project5final.request;

import lombok.Data;

@Data
public class CreateTodoRequest {
    private String title;
    private String description;
}

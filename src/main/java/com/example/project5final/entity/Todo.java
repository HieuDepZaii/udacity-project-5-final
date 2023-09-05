package com.example.project5final.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed = false;
    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    // getters and setters

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

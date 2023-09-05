package com.example.project5final.services;

import com.example.project5final.entity.Todo;
import com.example.project5final.exception.CommonException;
import com.example.project5final.repository.TodoRepository;
import com.example.project5final.request.CreateTodoRequest;
import com.example.project5final.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    //    create
    @Transactional
    public Todo createTodo(CreateTodoRequest request) {
        try {
            Todo newTodo = new Todo(request.getTitle(), request.getDescription());
            return todoRepository.save(newTodo);
        } catch (Exception e) {
            throw new CommonException("error");
        }
    }

    //    get
    public List<Todo> getAllTodos() {
        try {
            return todoRepository.findAll();
        } catch (Exception e) {
            throw new CommonException("error");
        }
    }

    @Transactional
    public Todo updateTodo(Long id, UpdateTodoRequest request) {
        try {
            Optional<Todo> oldTodoOptional = todoRepository.findById(id);
            if (oldTodoOptional.isPresent()) {
                Todo oldTodo = oldTodoOptional.get();
                oldTodo.setTitle(request.getTitle());
                oldTodo.setDescription(request.getDescription());
                oldTodo.setCompleted(request.getCompleted());
                oldTodo.setUpdateTime(LocalDateTime.now());
                return todoRepository.save(oldTodo);
            } else {
                throw new CommonException("not found record");
            }
        } catch (Exception e) {
            throw new CommonException("error");
        }
    }

    @Transactional
    public void deleteTodo(Long id) {
        try {
            Optional<Todo> oldTodoOptional = todoRepository.findById(id);
            if (oldTodoOptional.isPresent()) {
                todoRepository.deleteById(id);
            } else {
                throw new CommonException("record not found");
            }
        } catch (Exception e) {
            throw new CommonException("error");
        }
    }

    public Todo getDetail(Long id) {
        return todoRepository.findById(id).get();
    }
}

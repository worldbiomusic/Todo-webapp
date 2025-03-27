package io.github.webapp.service;

import io.github.webapp.entity.Todo;
import io.github.webapp.repository.TodoRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAllTodo();

    Optional<Todo> findByIdTodo(Integer id);

    void insertTodo(Todo todo);

    void updateTodo(Todo todo);

    void deleteTodo(Integer id);
}

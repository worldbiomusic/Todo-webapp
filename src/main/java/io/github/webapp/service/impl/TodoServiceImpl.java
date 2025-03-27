package io.github.webapp.service.impl;

import io.github.webapp.entity.Todo;
import io.github.webapp.repository.TodoRepository;
import io.github.webapp.service.TodoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodo() {
        return todoRepository.findAll();
    }
    @Override
    public Optional<Todo> findByIdTodo(Integer id) {
        return todoRepository.findById(id);
    }

    @Override
    public void insertTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.update(todo);
    }

    @Override
    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }
}

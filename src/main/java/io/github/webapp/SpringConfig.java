package io.github.webapp;

import io.github.webapp.repository.TodoRepository;
import io.github.webapp.service.TodoService;
import io.github.webapp.service.impl.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {
    private final TodoRepository todoRepository;

    @Bean
    public TodoService todoService() {
        return new TodoServiceImpl(todoRepository);
    }
}

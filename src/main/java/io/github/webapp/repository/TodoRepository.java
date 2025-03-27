package io.github.webapp.repository;

import io.github.webapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT t FROM Todo t WHERE t.todo LIKE %:todo%")
    Optional<Todo> findByTodo(@Param("todo") String todo);

    @Modifying
    @Query("UPDATE Todo t SET t.todo = :#{#todo.todo}, t.detail = :#{#todo.detail} WHERE t.id = :#{#todo.id}")
    int update(@Param("todo") Todo todo);
}

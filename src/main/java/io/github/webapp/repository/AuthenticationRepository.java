package io.github.webapp.repository;

import io.github.webapp.entity.Authentication;
import io.github.webapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication, String> {
    @Query("SELECT a FROM Authentication a WHERE a.username LIKE %:username%")
    Optional<Authentication> findByUsername(@Param("username") String username);
}

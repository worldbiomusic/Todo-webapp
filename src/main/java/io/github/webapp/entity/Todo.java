package io.github.webapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todos") // Entity 이름과 table 이름이 다르다면 명시해야 함
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Todo는 필수")
    private String todo;

    @Column(columnDefinition = "TEXT")
    @Size(min = 1,max = 100,message = "detail은 {min}-{max}자 이내로 작성")
    private String detail;

    @Column(name = "created_at") // java와 SQL 속성 매핑하기
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    // createdAt 자동 설정
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // updatedAt 자동 설정
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

package com.znyar.todoapp.models;

import com.znyar.todoapp.models.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "dateofcreated")
    private LocalDateTime dateOfCreated;

    @PrePersist
    public void init() {
        dateOfCreated = LocalDateTime.now();
        status = TaskStatus.ACTIVE;
    }

}

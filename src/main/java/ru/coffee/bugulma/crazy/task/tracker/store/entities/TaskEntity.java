package ru.coffee.bugulma.crazy.task.tracker.store.entities;

import javax.persistence.*;
import java.time.Instant;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String name;
    private Long ordinal;
    private Instant createdAt = Instant.now();
    private String description;
}

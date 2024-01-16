package ru.coffee.bugulma.crazy.task.tracker.store.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
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
@Table(name = "task_state")
public class TaskStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String name;
    private Long ordinal;
    @Builder.Default
    private Instant createdAt = Instant.now();
    @Builder.Default
    @OneToMany
    @JoinColumn(name = "task_state_id", referencedColumnName = "id")
    private List<TaskEntity> tasks = new ArrayList<>();

}

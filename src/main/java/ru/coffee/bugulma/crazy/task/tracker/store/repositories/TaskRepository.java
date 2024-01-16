package ru.coffee.bugulma.crazy.task.tracker.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.TaskEntity;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

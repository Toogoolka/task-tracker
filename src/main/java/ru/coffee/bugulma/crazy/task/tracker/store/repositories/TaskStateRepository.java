package ru.coffee.bugulma.crazy.task.tracker.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.TaskStateEntity;
@Repository
public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}

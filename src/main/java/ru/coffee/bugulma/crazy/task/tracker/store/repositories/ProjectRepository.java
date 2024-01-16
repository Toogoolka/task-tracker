package ru.coffee.bugulma.crazy.task.tracker.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.ProjectEntity;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByName(String name);
    Optional<ProjectEntity> findById(Long id);
}

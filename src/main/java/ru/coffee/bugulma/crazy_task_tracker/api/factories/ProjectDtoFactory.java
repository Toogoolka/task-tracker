package ru.coffee.bugulma.crazy_task_tracker.api.factories;

import org.springframework.stereotype.Component;
import ru.coffee.bugulma.crazy_task_tracker.api.dto.ProjectDto;
import ru.coffee.bugulma.crazy_task_tracker.store.entities.ProjectEntity;

@Component
public class ProjectDtoFactory {
    public ProjectDto createProjectDto(ProjectEntity entity) {
        return ProjectDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

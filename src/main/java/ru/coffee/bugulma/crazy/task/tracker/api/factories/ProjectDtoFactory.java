package ru.coffee.bugulma.crazy.task.tracker.api.factories;

import org.springframework.stereotype.Component;
import ru.coffee.bugulma.crazy.task.tracker.api.dto.ProjectDto;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.ProjectEntity;

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

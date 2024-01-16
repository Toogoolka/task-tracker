package ru.coffee.bugulma.crazy.task.tracker.api.factories;

import org.springframework.stereotype.Component;
import ru.coffee.bugulma.crazy.task.tracker.api.dto.TaskDto;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.TaskEntity;

/**
 * @author Vladislav Tugulev
 * @Date 14.01.2024
 */
@Component
public class TaskDtoFactory {
    public TaskDto createTaskDto(TaskEntity entity) {
        return TaskDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .description(entity.getDescription())
                .build();
    }
}

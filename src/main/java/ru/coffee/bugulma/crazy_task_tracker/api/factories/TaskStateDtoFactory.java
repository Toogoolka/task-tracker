package ru.coffee.bugulma.crazy_task_tracker.api.factories;

import ru.coffee.bugulma.crazy_task_tracker.api.dto.TaskStateDto;
import ru.coffee.bugulma.crazy_task_tracker.store.entities.TaskStateEntity;

public class TaskStateDtoFactory {
    public TaskStateDto createTaskStateDto(TaskStateEntity entity) {
        return TaskStateDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .ordinal(entity.getOrdinal())
                .build();
    }
}

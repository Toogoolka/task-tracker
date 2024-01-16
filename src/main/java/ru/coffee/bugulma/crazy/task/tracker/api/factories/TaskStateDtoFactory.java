package ru.coffee.bugulma.crazy.task.tracker.api.factories;

import org.springframework.stereotype.Component;
import ru.coffee.bugulma.crazy.task.tracker.api.dto.TaskStateDto;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.TaskStateEntity;
@Component
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

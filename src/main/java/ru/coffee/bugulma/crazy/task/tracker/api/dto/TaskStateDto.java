package ru.coffee.bugulma.crazy.task.tracker.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskStateDto {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Long ordinal;
    @NonNull
    @JsonProperty("crated_at")
    private Instant createdAt;
}

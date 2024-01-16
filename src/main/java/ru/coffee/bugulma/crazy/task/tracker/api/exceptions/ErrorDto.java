package ru.coffee.bugulma.crazy.task.tracker.api.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Vladislav Tugulev
 * @Date 14.01.2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {

    String error;
    @JsonProperty("error_description")
    String errorDescription;
}

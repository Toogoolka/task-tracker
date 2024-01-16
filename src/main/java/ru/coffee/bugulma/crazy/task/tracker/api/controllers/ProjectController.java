package ru.coffee.bugulma.crazy.task.tracker.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.coffee.bugulma.crazy.task.tracker.api.dto.ProjectDto;
import ru.coffee.bugulma.crazy.task.tracker.api.exceptions.BadRequestException;
import ru.coffee.bugulma.crazy.task.tracker.api.exceptions.NotFoundException;
import ru.coffee.bugulma.crazy.task.tracker.api.factories.ProjectDtoFactory;
import ru.coffee.bugulma.crazy.task.tracker.store.entities.ProjectEntity;
import ru.coffee.bugulma.crazy.task.tracker.store.repositories.ProjectRepository;

import java.util.Objects;

/**
 * @author Vladislav Tugulev
 * @Date 14.01.2024
 */
@RequiredArgsConstructor
@Transactional
@RestController
public class ProjectController {

    private final ProjectDtoFactory projectDtoFactory;
    private final ProjectRepository projectRepository;

    public static final String CREATE_PROJECT = "/api/projects";
    public static final String EDIT_PROJECT = "/api/projects/{project_id}";

    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {
        projectRepository
                .findByName(name)
                .ifPresent(project -> {
                    throw new BadRequestException(String.format("Project \"%s\" already exists.", name));
                });

        ProjectEntity project = projectRepository.saveAndFlush(
                ProjectEntity.builder()
                        .name(name)
                        .build()
        );
        return projectDtoFactory.createProjectDto(project);
    }

    @PatchMapping(EDIT_PROJECT)
    public ProjectDto editProject(
            @PathVariable("project_id") Long projectId,
            @RequestParam String name) {

        if (name.trim().isEmpty()) {
            throw new BadRequestException("Project name can't be empty");
        }


        ProjectEntity project = projectRepository
                .findById(projectId)
                .orElseThrow(() -> {
                    throw new NotFoundException(String.format("Project with id \"%s\" doesn't exist", projectId));
                });

        projectRepository
                .findByName(name)
                .filter(anotherProject -> !Objects.equals(anotherProject.getId(), projectId))
                .ifPresent(anotherProject -> {
                    throw new BadRequestException(String.format("Project \"%s\" already exists.", name));
                });
        project.setName(name);

        projectRepository.saveAndFlush(project);
        return projectDtoFactory.createProjectDto(project);
    }
}

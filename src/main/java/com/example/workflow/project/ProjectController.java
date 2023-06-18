package com.example.workflow.project;

import com.example.workflow.project.dto.CreateProjectDto;
import com.example.workflow.project.dto.ProjectDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping(value = "/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public Page<ProjectDto> findAll(ProjectSpecification projectSpecification, Pageable pageable) {
        log.info("ProjectController findAll, pageable: {}, {}", pageable, projectSpecification);
        return projectService.findAll(projectSpecification, pageable);
    }

    @GetMapping("/{id}")
    public ProjectDto get(@PathVariable("id") final UUID projectId) throws NotFoundException {
        return projectService.get(projectId);
    }

    @PostMapping
    public ProjectDto create(@RequestBody CreateProjectDto createProjectDto) {
        return projectService.create(createProjectDto);
    }

    @PostMapping("/mock")
    public void createMockData() {
        log.info("ProjectController createMockData");
        projectService.createMockData();
    }
}

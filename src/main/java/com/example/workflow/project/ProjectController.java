package com.example.workflow.project;

import com.example.workflow.project.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public Page<ProjectDto> findAll(ProjectSpecification projectSpecification, Pageable pageable) {
        log.info("ProjectController findAll, pageable: {}", pageable);
        return projectService.findAll(projectSpecification, pageable);
    }

    @PostMapping
    public void createMockData() {
        log.info("ProjectController createMockData");
        projectService.createMockData();
    }
}

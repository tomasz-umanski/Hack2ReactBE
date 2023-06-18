package com.example.workflow.project;

import com.example.workflow.project.dao.Project;
import com.example.workflow.project.dto.CreateProjectDto;
import com.example.workflow.project.dto.ProjectDto;
import com.example.workflow.project.dto.ProjectOrganizationDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.time.OffsetDateTime.now;

@Service
@RequiredArgsConstructor
class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public Page<ProjectDto> findAll(ProjectSpecification projectSpecification, Pageable pageable) {
        return projectRepository.findAll(projectSpecification, pageable).map(projectMapper::toDto);
    }

    public ProjectDto get(UUID projectId) throws NotFoundException {
        final var project = projectRepository.findById(projectId);

        if(project.isEmpty()) {
            throw new NotFoundException(String.format("Cannot find project with id: %s", projectId));
        }

        return projectMapper.toDto(project.get());
    }

    public ProjectDto create(CreateProjectDto createProjectDto) {
        final var createProject = projectMapper.toEntity(createProjectDto);
        return projectMapper.toDto(projectRepository.save(createProject));
    }

    @Transactional
    public void createMockData() {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        List<ProjectOrganizationDto> projectOrganizationDtoList = new ArrayList<>();

        ProjectOrganizationDto projectOrganizationDto1 = ProjectOrganizationDto.builder()
                .id("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .name("Organizacja 1")
                .build();
        projectOrganizationDtoList.add(projectOrganizationDto1);

        ProjectOrganizationDto projectOrganizationDto2 = ProjectOrganizationDto.builder()
                .id("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .name("Organizacja 2")
                .build();
        projectOrganizationDtoList.add(projectOrganizationDto2);

        ProjectDto projectDto1 = ProjectDto.builder()
                .id("7fb08bf6-0d19-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 1, 1, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 2, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Project 1")
                .content("Project 1 content")
                .localization("Project 1 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto1);

        ProjectDto projectDto2 = ProjectDto.builder()
                .id("826024d8-0d19-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 1, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 4, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Project 2")
                .content("Project 2 content")
                .localization("Project 2 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto2);

        ProjectDto projectDto3 = ProjectDto.builder()
                .id("12345678-1234-1234-1234-1234567890ab")
                .startDate(OffsetDateTime.of(2023, 1, 5, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 6, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Project 3")
                .content("Project 3 content")
                .localization("Project 3 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto3);

        ProjectDto projectDto4 = ProjectDto.builder()
                .id("abcdef12-3456-7890-abcd-ef1234567890")
                .startDate(OffsetDateTime.of(2023, 1, 7, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 8, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Project 4")
                .content("Project 4 content")
                .localization("Project 4 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto4);

        ProjectDto projectDto5 = ProjectDto.builder()
                .id("918c7b98-0d35-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 2, 14, 9, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 2, 15, 9, 0, 0, 0, ZoneOffset.UTC))
                .title("Project 5")
                .content("Project 5 content")
                .localization("Project 5 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto5);

        ProjectDto projectDto6 = ProjectDto.builder()
                .id("95579c1c-0d35-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 3, 21, 18, 30, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 3, 22, 18, 30, 0, 0, ZoneOffset.UTC))
                .title("Project 6")
                .content("Project 6 content")
                .localization("Project 6 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(projectOrganizationDtoList)
                .build();
        projectDtoList.add(projectDto6);

        List<Project> projects = projectMapper.toEntityList(projectDtoList);
        projectRepository.saveAll(projects);
    }

}

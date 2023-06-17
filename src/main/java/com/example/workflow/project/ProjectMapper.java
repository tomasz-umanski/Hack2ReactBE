package com.example.workflow.project;

import com.example.workflow.project.dao.Project;
import com.example.workflow.project.dto.ProjectDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface ProjectMapper {
    ProjectDto toDto(Project project);
    List<Project> toEntityList(List<ProjectDto> projectDtoList);
}

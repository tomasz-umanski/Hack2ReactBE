package com.example.workflow.workspace;

import com.example.workflow.workspace.dao.Workspace;
import com.example.workflow.workspace.dto.CreateWorkspaceDto;
import com.example.workflow.workspace.dto.WorkspaceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface WorkspaceMapper {
    WorkspaceDto toDto(Workspace workSpace);
    Workspace toEntity(CreateWorkspaceDto createWorkSpaceDto);
}

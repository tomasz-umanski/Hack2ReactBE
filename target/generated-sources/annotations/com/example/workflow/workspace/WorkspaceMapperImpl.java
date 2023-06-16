package com.example.workflow.workspace;

import com.example.workflow.workspace.dao.Workspace;
import com.example.workflow.workspace.dto.CreateWorkspaceDto;
import com.example.workflow.workspace.dto.WorkspaceDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T17:55:47+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
class WorkspaceMapperImpl implements WorkspaceMapper {

    @Override
    public WorkspaceDto toDto(Workspace workSpace) {
        if ( workSpace == null ) {
            return null;
        }

        WorkspaceDto workspaceDto = new WorkspaceDto();

        return workspaceDto;
    }

    @Override
    public Workspace toEntity(CreateWorkspaceDto createWorkSpaceDto) {
        if ( createWorkSpaceDto == null ) {
            return null;
        }

        Workspace workspace = new Workspace();

        workspace.setName( createWorkSpaceDto.getName() );

        return workspace;
    }
}

package com.example.workflow.workspace;

import javax.transaction.Transactional;

import com.example.workflow.workspace.dto.CreateWorkspaceDto;
import com.example.workflow.workspace.dto.WorkspaceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class WorkspaceService {
    private final WorkspaceRepository workSpaceRepository;
    private final WorkspaceMapper workSpaceMapper;

    public Page<WorkspaceDto> findAll(WorkspaceSpecification workSpaceSpecification, Pageable pageable) {
        log.info("WorkSpace findAll");
        return workSpaceRepository.findAll(workSpaceSpecification, pageable).map(workSpaceMapper::toDto);
    }

    @Transactional
    public WorkspaceDto create(final CreateWorkspaceDto createWorkSpaceDto) {
        log.info("WorkSpace create");
        final var createWorkSpace = workSpaceMapper.toEntity(createWorkSpaceDto);
        return workSpaceMapper.toDto(workSpaceRepository.save(createWorkSpace));
    }
}

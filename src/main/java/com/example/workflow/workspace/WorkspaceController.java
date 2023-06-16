package com.example.workflow.workspace;

import com.example.workflow.workspace.dto.CreateWorkspaceDto;
import com.example.workflow.workspace.dto.WorkspaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/workspace")
class WorkspaceController {
    private final WorkspaceService workSpaceService;

    @GetMapping
    public Page<WorkspaceDto> findAll(WorkspaceSpecification workSpaceSpecification, Pageable pageable) {
        return workSpaceService.findAll(workSpaceSpecification, pageable);
    }

    @PostMapping
    public WorkspaceDto create(@RequestBody CreateWorkspaceDto createWorkSpaceDto) {
        return workSpaceService.create(createWorkSpaceDto);
    }
}

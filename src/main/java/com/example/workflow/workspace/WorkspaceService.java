package com.example.workflow.workspace;

import java.util.HashMap;
import java.util.Map;
import javax.transaction.Transactional;

import com.example.workflow.workspace.dto.CreateWorkspaceDto;
import com.example.workflow.workspace.dto.WorkspaceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.rest.dto.runtime.StartProcessInstanceDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class WorkspaceService {
    private static final String HACK_2_REACT_PROCESS = "hack2react-process";

    private final ProcessEngine processEngine;
    private final WorkspaceRepository workSpaceRepository;
    private final WorkspaceMapper workSpaceMapper;

    public Page<WorkspaceDto> findAll(WorkspaceSpecification workSpaceSpecification, Pageable pageable) {
        log.info("WorkSpace findAll");
        return workSpaceRepository.findAll(workSpaceSpecification, pageable).map(workSpaceMapper::toDto);
    }

    @Transactional
    public WorkspaceDto create(final CreateWorkspaceDto createWorkSpaceDto) {
        log.info("WorkSpace create");

/*        Map<String,Object> variables = new HashMap<>();
        variables.put("id", "2342342-34-23-42-34-23-4");
        variables.put("name", "siema");

        ProcessInstance processInstance = processEngine.getRuntimeService()
            .startProcessInstanceByKey(HACK_2_REACT_PROCESS, variables);*/

        final var createWorkspace = workSpaceMapper.toEntity(createWorkSpaceDto);
        final var savedWorkspace = workSpaceRepository.save(createWorkspace);
        return workSpaceMapper.toDto(savedWorkspace);
    }
}

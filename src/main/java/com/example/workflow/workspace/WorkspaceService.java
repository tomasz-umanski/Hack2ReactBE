package com.example.workflow.workspace;

import com.example.workflow.workspace.dto.CreateContactDto;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class WorkspaceService {
    private static final String CONTACT_PROCESS = "ContactProcess";

    private final ProcessEngine processEngine;

    private final WorkspaceRepository workspaceRepository;

    private final WorkspaceMapper workspaceMapper;

    public void callContactProcess(CreateContactDto createContactDto) {
        final var createWorkSpace = workspaceMapper.toEntity(createContactDto);
        workspaceRepository.save(createWorkSpace);

        Map<String,Object> variables = new HashMap<>();
        variables.put("name", createContactDto.getName());
        variables.put("organization", createContactDto.getOrganization());
        variables.put("topic", createContactDto.getTopic());
        variables.put("category", createContactDto.getCategory());
        variables.put("content", createContactDto.getContent());

        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey(CONTACT_PROCESS, variables);
    }
}

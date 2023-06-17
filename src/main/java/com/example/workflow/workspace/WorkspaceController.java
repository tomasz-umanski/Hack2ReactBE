package com.example.workflow.workspace;

import com.example.workflow.workspace.dto.CreateContactDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/workspace")
@RequiredArgsConstructor
class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping
    public void callContactProcess(@RequestBody CreateContactDto createContactDto) {
        log.info("WorkspaceController callContactProcess");
        workspaceService.callContactProcess(createContactDto);
    }
}

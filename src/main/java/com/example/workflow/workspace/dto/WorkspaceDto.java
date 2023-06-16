package com.example.workflow.workspace.dto;

import javax.validation.constraints.NotBlank;

public class WorkspaceDto{

    @NotBlank(message = "id cannot be blank")
    private String id;

    @NotBlank(message = "name cannot be blank")
    private String name;

}

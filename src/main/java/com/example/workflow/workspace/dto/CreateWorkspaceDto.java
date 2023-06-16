package com.example.workflow.workspace.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkspaceDto {

    @NotBlank(message = "name cannot be blank")
    private String name;

}

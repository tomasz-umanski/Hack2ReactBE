package com.example.workflow.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactDto {
    @NotBlank
    private String name;
    @NotBlank
    private String organization;
    @NotBlank
    private String topic;
    @NotBlank
    private String category;
    @NotBlank
    private String content;
}

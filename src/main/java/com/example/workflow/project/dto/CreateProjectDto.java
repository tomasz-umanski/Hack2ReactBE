package com.example.workflow.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectDto {
    @NotBlank
    private String category;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String localization;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastUpdated;
    private boolean active;
    @NotBlank
    private String mainOrganizationId;
    @NotBlank
    private String externalUrl;
    private List<ProjectOrganizationDto> organizationList;
    private List<ProjectAccountDto> targetList;
}

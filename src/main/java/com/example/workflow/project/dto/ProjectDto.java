package com.example.workflow.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String id;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String title;
    private String content;
    private String localization;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastUpdated;
    private boolean active;
    private String mainOrganizationId;
    private List<ProjectOrganizationDto> organizationList;
}

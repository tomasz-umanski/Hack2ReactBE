package com.example.workflow.organization.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private String id;

    private String name;

    private List<OrganizationEventDto> eventList;

    private List<OrganizationProjectDto> projectList;
}

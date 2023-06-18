package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import com.example.workflow.organization.dto.OrganizationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface OrganizationMapper {
    OrganizationDto toDto(Organization organization);
}

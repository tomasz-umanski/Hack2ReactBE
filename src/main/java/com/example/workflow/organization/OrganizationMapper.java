package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import com.example.workflow.organization.dto.CreateOrganizationDto;
import com.example.workflow.organization.dto.OrganizationDto;
import com.example.workflow.user.dao.User;
import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface OrganizationMapper {
    OrganizationDto toDto(Organization organization);
    Organization toEntity(CreateOrganizationDto createOrganizationDto);
}

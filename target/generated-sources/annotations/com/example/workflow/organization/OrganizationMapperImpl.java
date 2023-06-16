package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import com.example.workflow.organization.dto.CreateOrganizationDto;
import com.example.workflow.organization.dto.OrganizationDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-17T00:53:39+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDto toDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        return organizationDto;
    }

    @Override
    public Organization toEntity(CreateOrganizationDto createOrganizationDto) {
        if ( createOrganizationDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        return organization;
    }
}

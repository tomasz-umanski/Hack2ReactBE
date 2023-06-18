package com.example.workflow.organization;

import com.example.workflow.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public Page<OrganizationDto> findAll(OrganizationSpecification organizationSpecification, Pageable pageable) {
        return organizationRepository.findAll(organizationSpecification, pageable).map(organizationMapper::toDto);
    }
}

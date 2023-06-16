package com.example.workflow.organization;

import com.example.workflow.organization.dto.CreateOrganizationDto;
import com.example.workflow.organization.dto.OrganizationDto;
import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public Page<OrganizationDto> findAll(OrganizationSpecification organizationSpecification, Pageable pageable) {
        log.info("WorkSpace findAll");
        return organizationRepository.findAll(organizationSpecification, pageable).map(organizationMapper::toDto);
    }

    @Transactional
    public OrganizationDto create(final CreateOrganizationDto createOrganizationDto) {
        log.info("WorkSpace create");
        final var createUser = organizationMapper.toEntity(createOrganizationDto);
        return organizationMapper.toDto(organizationRepository.save(createUser));
    }
}

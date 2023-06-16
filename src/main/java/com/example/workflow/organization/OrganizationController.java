package com.example.workflow.organization;

import com.example.workflow.organization.dto.CreateOrganizationDto;
import com.example.workflow.organization.dto.OrganizationDto;
import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/organization")
class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping
    public Page<OrganizationDto> findAll(OrganizationSpecification organizationSpecification, Pageable pageable) {
        return organizationService.findAll(organizationSpecification, pageable);
    }

    @PostMapping
    public OrganizationDto create(@RequestBody CreateOrganizationDto createOrganizationDto) {
        return organizationService.create(createOrganizationDto);
    }
}

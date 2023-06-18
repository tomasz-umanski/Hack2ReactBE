package com.example.workflow.organization;

import com.example.workflow.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping
    public Page<OrganizationDto> findAll(OrganizationSpecification organizationSpecification, Pageable pageable) {
        log.info("OrganizationController findAll");
        return organizationService.findAll(organizationSpecification, pageable);
    }
}

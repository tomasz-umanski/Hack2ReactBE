package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import com.example.workflow.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public Page<OrganizationDto> findAll(OrganizationSpecification organizationSpecification, Pageable pageable) {
        return organizationRepository.findAll(organizationSpecification, pageable).map(organizationMapper::toDto);
    }

    @Transactional
    public void createMockData() {
        List<OrganizationDto> organizationDtoList = new ArrayList<>();

        OrganizationDto organizationDto1 = OrganizationDto.builder()
                .id("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .name("Organization 1")
                .build();
        organizationDtoList.add(organizationDto1);

        OrganizationDto organizationDto2 = OrganizationDto.builder()
                .id("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .name("Organization 2")
                .build();
        organizationDtoList.add(organizationDto2);

        List<Organization> organizationList = organizationMapper.toEntityList(organizationDtoList);
        organizationRepository.saveAll(organizationList);
    }
}

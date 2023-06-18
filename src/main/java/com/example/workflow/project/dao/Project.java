package com.example.workflow.project.dao;

import com.example.workflow.organization.dao.AccountType;
import com.example.workflow.organization.dao.Organization;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "project")
public class Project {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private UUID id = UUID.randomUUID();

    @Column(name = "category")
    private String category;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "localization")
    private String localization;

    @Column(name = "creation_date")
    private OffsetDateTime creationDate;

    @Column(name = "last_updated")
    private OffsetDateTime lastUpdated;

    @Column(name = "active")
    private boolean active;

    @Column(name = "main_organization_id")
    private String mainOrganizationId;

    @Column(name = "external_url")
    private String externalUrl;

    @ManyToMany
    @JoinTable(
            name = "project_organization",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id")
    )
    private List<Organization> organizationList;

    @ManyToMany
    @JoinTable(
            name = "project_target",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "account_type_id")
    )
    private List<AccountType> targetList;
}

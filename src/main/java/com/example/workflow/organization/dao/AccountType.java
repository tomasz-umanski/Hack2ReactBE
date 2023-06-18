package com.example.workflow.organization.dao;

import com.example.workflow.project.dao.Project;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "account_type_dictionary")
public class AccountType {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "targetList")
    private List<Project> projectList;
}

package com.example.workflow.user.dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "portal_user")
public class User {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private String id = UUID.randomUUID().toString();

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

}

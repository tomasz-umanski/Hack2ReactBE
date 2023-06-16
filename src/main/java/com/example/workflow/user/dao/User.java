package com.example.workflow.user.dao;

import com.example.workflow.organization.dao.Organization;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
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

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "login", nullable = false, unique = false)
    private String login;

}

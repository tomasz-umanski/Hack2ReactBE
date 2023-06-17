package com.example.workflow.organization.dao;

import com.example.workflow.event.dao.Event;
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
@Table(name = "organization")
public class Organization {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "organizationList")
    private List<Event> eventList;
}

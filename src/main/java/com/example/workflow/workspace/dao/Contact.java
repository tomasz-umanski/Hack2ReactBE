package com.example.workflow.workspace.dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "project")
public class Contact {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "organization")
    private String organization;

    @Column(name = "topic")
    private String topic;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;
}

package com.example.workflow.event.dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "event")
public class Event {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "UUID")
    private UUID id = UUID.randomUUID();

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;
}

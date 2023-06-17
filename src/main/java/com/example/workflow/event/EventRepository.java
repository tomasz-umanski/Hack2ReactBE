package com.example.workflow.event;

import com.example.workflow.event.dao.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface EventRepository extends JpaRepository<Event, UUID>, JpaSpecificationExecutor<Event> {
}

package com.example.workflow.workspace;

import com.example.workflow.workspace.dao.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkspaceRepository extends JpaRepository<Contact, UUID>, JpaSpecificationExecutor<Contact> {
}

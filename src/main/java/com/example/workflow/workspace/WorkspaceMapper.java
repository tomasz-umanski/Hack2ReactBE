package com.example.workflow.workspace;

import com.example.workflow.workspace.dao.Contact;
import com.example.workflow.workspace.dto.CreateContactDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface WorkspaceMapper {
    Contact toEntity(CreateContactDto createContactDto);
}

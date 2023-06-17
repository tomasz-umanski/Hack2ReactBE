package com.example.workflow.event;

import com.example.workflow.event.dao.Event;
import com.example.workflow.event.dto.EventDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface EventMapper {
    EventDto toDto(Event event);
    List<Event> toEntityList(List<EventDto> eventDtoList);
}

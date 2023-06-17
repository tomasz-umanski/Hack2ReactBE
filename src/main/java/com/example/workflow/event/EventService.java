package com.example.workflow.event;

import com.example.workflow.event.dao.Event;
import com.example.workflow.event.dto.EventDto;
import com.example.workflow.event.dto.EventOrganizationDto;
import com.example.workflow.organization.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static java.time.OffsetDateTime.now;

@Service
@RequiredArgsConstructor
class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public Page<EventDto> findAll(EventSpecification eventSpecification, Pageable pageable) {
        return eventRepository.findAll(eventSpecification, pageable).map(eventMapper::toDto);
    }

    public List<String> findAllByMonthAndYear(final int month, final int year) {
        List<Event> eventList = eventRepository.findAll();

        YearMonth targetMonth = YearMonth.of(year, month);
        List<Event> filteredEvents = eventList.stream()
                .filter(event -> {
                    YearMonth eventStartMonth = YearMonth.from(event.getStartDate());
                    YearMonth eventEndMonth = YearMonth.from(event.getEndDate());
                    return !targetMonth.isBefore(eventStartMonth) && !targetMonth.isAfter(eventEndMonth);
                }).toList();

        return filteredEvents.stream()
                .map(event -> event.getStartDate().toString()).toList();
    }

    @Transactional
    public void createMockData() {
        List<EventDto> eventDtoList = new ArrayList<>();

        List<EventOrganizationDto> eventOrganizationDtoList = new ArrayList<>();

        EventOrganizationDto eventOrganizationDto1 = EventOrganizationDto.builder()
                .id("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .name("Organizacja 1")
                .build();
        eventOrganizationDtoList.add(eventOrganizationDto1);

        EventOrganizationDto eventOrganizationDto2 = EventOrganizationDto.builder()
                .id("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .name("Organizacja 2")
                .build();
        eventOrganizationDtoList.add(eventOrganizationDto2);

        EventDto eventDto1 = EventDto.builder()
                .id("7fb08bf6-0d19-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 1, 1, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 2, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Event 1")
                .content("Event 1 content")
                .localization("Event 1 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto1);

        EventDto eventDto2 = EventDto.builder()
                .id("826024d8-0d19-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 1, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 4, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Event 2")
                .content("Event 2 content")
                .localization("Event 2 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto2);

        EventDto eventDto3 = EventDto.builder()
                .id("12345678-1234-1234-1234-1234567890ab")
                .startDate(OffsetDateTime.of(2023, 1, 5, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 6, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Event 3")
                .content("Event 3 content")
                .localization("Event 3 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto3);

        EventDto eventDto4 = EventDto.builder()
                .id("abcdef12-3456-7890-abcd-ef1234567890")
                .startDate(OffsetDateTime.of(2023, 1, 7, 12, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 1, 8, 12, 0, 0, 0, ZoneOffset.UTC))
                .title("Event 4")
                .content("Event 4 content")
                .localization("Event 4 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("9f44bb34-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto4);

        EventDto eventDto5 = EventDto.builder()
                .id("918c7b98-0d35-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 2, 14, 9, 0, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 2, 15, 9, 0, 0, 0, ZoneOffset.UTC))
                .title("Event 5")
                .content("Event 5 content")
                .localization("Event 5 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto5);

        EventDto eventDto6 = EventDto.builder()
                .id("95579c1c-0d35-11ee-be56-0242ac120002")
                .startDate(OffsetDateTime.of(2023, 3, 21, 18, 30, 0, 0, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(2023, 3, 22, 18, 30, 0, 0, ZoneOffset.UTC))
                .title("Event 6")
                .content("Event 6 content")
                .localization("Event 6 location")
                .creationDate(now())
                .lastUpdated(now())
                .active(true)
                .mainOrganizationId("7a6460f8-0d2f-11ee-be56-0242ac120002")
                .organizationList(eventOrganizationDtoList)
                .build();
        eventDtoList.add(eventDto6);

        List<Event> events = eventMapper.toEntityList(eventDtoList);
        eventRepository.saveAll(events);
    }

}

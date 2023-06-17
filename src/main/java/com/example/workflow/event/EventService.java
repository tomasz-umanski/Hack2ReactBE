package com.example.workflow.event;

import com.example.workflow.event.dao.Event;
import com.example.workflow.event.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.OffsetDateTime.now;

@Service
@RequiredArgsConstructor
class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<String> findAll(final int month, final int year) {
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

        EventDto eventDto1 = EventDto.builder()
                .id("7fb08bf6-0d19-11ee-be56-0242ac120002")
                .startDate(now())
                .endDate(now())
                .build();
        eventDtoList.add(eventDto1);

        EventDto eventDto2 = EventDto.builder()
                .id("826024d8-0d19-11ee-be56-0242ac120002")
                .startDate(now())
                .endDate(now())
                .build();
        eventDtoList.add(eventDto2);

        EventDto eventDto3 = EventDto.builder()
                .id("12345678-1234-1234-1234-1234567890ab")
                .startDate(now())
                .endDate(now())
                .build();
        eventDtoList.add(eventDto3);

        EventDto eventDto4 = EventDto.builder()
                .id("abcdef12-3456-7890-abcd-ef1234567890")
                .startDate(now())
                .endDate(now())
                .build();
        eventDtoList.add(eventDto4);

        List<Event> events = eventMapper.toEntityList(eventDtoList);
        eventRepository.saveAll(events);
    }

}

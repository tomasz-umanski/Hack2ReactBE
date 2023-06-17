package com.example.workflow.event;

import com.example.workflow.event.dto.EventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public Page<EventDto> findAll(EventSpecification eventSpecification, Pageable pageable) {
        log.info("EventController findAll, pageable: {}", pageable);
        return eventService.findAll(eventSpecification, pageable);
    }

    @GetMapping("/eventDate")
    public List<String> findAllByMonthAndYear(@RequestParam final int month, @RequestParam final int year) {
        log.info("EventController findAll, month: {}, year: {}", month, year);
        return eventService.findAllByMonthAndYear(month, year);
    }

    @PostMapping
    public void createMockData() {
        log.info("EventDateController createMockData");
        eventService.createMockData();
    }
}

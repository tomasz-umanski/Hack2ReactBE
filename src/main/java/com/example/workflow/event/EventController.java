package com.example.workflow.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/event")
@RequiredArgsConstructor
class EventController {
    private final EventService eventService;

    @GetMapping("/eventDate")
    public List<String> findAllByMonthAndYear(@RequestParam final int month, @RequestParam final int year) {
        log.info("EventController findAll, month: {}, year: {}", month, year);
        return eventService.findAll(month, year);
    }

    @PostMapping("/eventDate")
    public void createMockData() {
        log.info("EventDateController createMockData");
        eventService.createMockData();
    }
}

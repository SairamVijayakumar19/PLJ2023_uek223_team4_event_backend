package com.example.demo.domain.event;

import com.example.demo.domain.event.dto.EventDTO;
import com.example.demo.domain.event.dto.EventMapper;
import com.example.demo.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@Log4j2
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMapper eventMapper;

    @Operation(summary = "Retrieve all events", description = "Returns a list of all available events.")
    @PreAuthorize("hasAuthority('EVENT_READ')")
    @GetMapping({"", "/"})
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @Operation(summary = "Get event by ID", description = "Returns a specific event by its unique ID.")
    @PreAuthorize("hasAuthority('EVENT_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable UUID id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new event", description = "Creates and returns the newly created event.")
    @PreAuthorize("hasAuthority('EVENT_CREATE')")
    @PostMapping({"", "/"})
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }

    @Operation(summary = "Update an existing event", description = "Updates and returns the modified event.")
    @PreAuthorize("hasAuthority('EVENT_MODIFY')")
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable UUID id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }

    @Operation(summary = "Delete an event", description = "Deletes the event with the provided ID.")
    @PreAuthorize("hasAuthority('EVENT_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get participants of an event", description = "Returns a paginated list of participants of the specified event.")
    @PreAuthorize("hasAuthority('EVENT_READ_PARTICIPANTS')")
    @GetMapping("/{id}/participants")
    public ResponseEntity<Page<User>> getEventParticipants(@PathVariable UUID id, Pageable pageable) {
        return ResponseEntity.ok(eventService.getEventParticipants(id, pageable));
    }
}

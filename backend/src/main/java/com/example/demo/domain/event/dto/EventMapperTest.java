package com.example.demo.domain.event.dto;

import com.example.demo.domain.event.Event;
import com.example.demo.domain.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapperTest {

    @Autowired
    private UserMapper userMapper;

    public Event fromDTO(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setEventName(eventDTO.getEventName());
        event.setDate(eventDTO.getDate());
        event.setLocation(eventDTO.getLocation());
        event.setGuestList(eventDTO.getGuestList().stream().map(userMapper::fromDTO).collect(Collectors.toList()));
        return event;
    }

    public EventDTO toDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setDate(event.getDate());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setGuestList(event.getGuestList().stream().map(userMapper::toDTO).collect(Collectors.toList()));
        return eventDTO;
    }

    public List<EventDTO> toDTOs(List<Event> events) {
        return events.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

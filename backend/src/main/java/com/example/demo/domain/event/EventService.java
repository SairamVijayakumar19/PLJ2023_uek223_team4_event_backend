package com.example.demo.domain.event;

import com.example.demo.domain.event.dto.EventDTO;
import com.example.demo.domain.event.dto.EventMapperTest;
import com.example.demo.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapperTest eventMapper;

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOs(events);
    }

    public Optional<EventDTO> getEventById(UUID id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(eventMapper::toDTO);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.fromDTO(eventDTO);
        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    public EventDTO updateEvent(UUID id, EventDTO eventDTO) {
        if(eventRepository.existsById(id)) {
            Event event = eventMapper.fromDTO(eventDTO);
            event.setId(id);
            event = eventRepository.save(event);
            return eventMapper.toDTO(event);
        }
        return null;
    }

    public void deleteEvent(UUID id) {
        eventRepository.deleteById(id);
    }

    public Page<User> getEventParticipants(UUID eventId, Pageable pageable) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            List<User> guestList = eventOptional.get().getGuestList();
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), guestList.size());
            List<User> subList = guestList.subList(start, end);

            return new PageImpl<>(subList, pageable, guestList.size());
        }
        return Page.empty();
    }


}

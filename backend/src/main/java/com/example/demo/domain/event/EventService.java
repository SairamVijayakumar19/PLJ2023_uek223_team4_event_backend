package com.example.demo.domain.event;

import com.example.demo.domain.event.dto.EventDTO;
import com.example.demo.domain.event.dto.EventMapperTest;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapperTest eventMapper;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOs(events);
    }

    @Transactional
    public Optional<EventDTO> getEventById(UUID id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(eventMapper::toDTO);
    }

    @Transactional
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.fromDTO(eventDTO);
        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    @Transactional
    public EventDTO updateEvent(UUID id, EventDTO eventDTO) {
        if(eventRepository.existsById(id)) {
            Event event = eventMapper.fromDTO(eventDTO);
            event.setId(id);
            event = eventRepository.save(event);
            return eventMapper.toDTO(event);
        }
        return null;
    }

    @Transactional
    public void deleteEvent(UUID id) {
        eventRepository.deleteById(id);
    }

    @Transactional
    public Page<User> getEventParticipants(UUID eventId, Pageable pageable) {
        List<User> usersParticipatingInEvent = userRepository.findByEventList_Id(eventId);

        int pageSize = Math.min(1, pageable.getPageSize());
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageSize, usersParticipatingInEvent.size());
        List<User> subList = usersParticipatingInEvent.subList(start, end);

        return new PageImpl<>(subList, pageable, usersParticipatingInEvent.size());
    }


}

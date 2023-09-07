package com.example.demo.domain.event;

import com.example.demo.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Integer id, Event event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        }
        return null;
    }

    public Page<User> getEventParticipants(Integer eventId, Pageable pageable) {
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

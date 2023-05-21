package com.example.hackathon.services;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Volunteer;
import com.example.hackathon.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Volunteer> getAllById(Long id) {
        return eventRepository.getAllById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setAddress(updatedEvent.getAddress());
            event.setOrganization(updatedEvent.getOrganization());
            event.setFromDate(updatedEvent.getFromDate());
            event.setUntilDate(updatedEvent.getUntilDate());
            event.setVolunteersAmount(updatedEvent.getVolunteersAmount());
            event.setSkills(updatedEvent.getSkills());
            event.setAdditionalRequirements(updatedEvent.getAdditionalRequirements());
            event.setSponsors(updatedEvent.getSponsors());
            return eventRepository.save(event);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

package com.example.hackathon.services;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {

    List<Event> getAllEvents();
    List<Volunteer> getAllById(Long id);
    Event getEventById(Long id);
    Event saveEvent(Event event);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
}

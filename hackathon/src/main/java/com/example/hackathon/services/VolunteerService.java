package com.example.hackathon.services;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Volunteer;

import java.util.List;

public interface VolunteerService {
    List<Volunteer> getAllVolunteers();
    List<Event> getAllById(Long id);
    Volunteer getVolunteerById(Long id);
    Volunteer saveVolunteer(Volunteer volunteer);
    Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer);
    void deleteVolunteer(Long id);
}

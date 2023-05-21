package com.example.hackathon.services;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Volunteer;
import com.example.hackathon.repositories.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @Override
    public List<Event> getAllById(Long id) {
        return volunteerRepository.getAllById(id);
    }

    @Override
    public Volunteer getVolunteerById(Long id) {
        Optional<Volunteer> optionalVolunteer = volunteerRepository.findById(id);
        return optionalVolunteer.orElse(null);
    }

    @Override
    public Volunteer saveVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer) {
        Optional<Volunteer> optionalVolunteer = volunteerRepository.findById(id);
        if (optionalVolunteer.isPresent()) {
            Volunteer volunteer = optionalVolunteer.get();
            volunteer.setAccount(updatedVolunteer.getAccount());
            volunteer.setSkills(updatedVolunteer.getSkills());
            volunteer.setInterests(updatedVolunteer.getInterests());
            volunteer.setLevel(updatedVolunteer.getLevel());
            volunteer.setExperiencePoints(updatedVolunteer.getExperiencePoints());
            volunteer.setCity(updatedVolunteer.getCity());
            return volunteerRepository.save(volunteer);
        }
        return null;
    }

    @Override
    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}

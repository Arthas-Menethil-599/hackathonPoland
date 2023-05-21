package com.example.hackathon.repositories;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    List<Event> getAllById(Long id);
}

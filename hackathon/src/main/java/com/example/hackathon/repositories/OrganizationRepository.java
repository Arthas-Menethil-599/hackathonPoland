package com.example.hackathon.repositories;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization getOrganizationById(Long organizationId);
    List<Event> getAllById(Long id);
}

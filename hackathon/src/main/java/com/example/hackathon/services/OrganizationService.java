package com.example.hackathon.services;

import com.example.hackathon.entities.Event;
import com.example.hackathon.entities.Organization;
import com.example.hackathon.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrganizationService {

    List<Organization> getAllOrganizations();
    Organization getOrganizationById(Long id);
    Organization saveOrganization(Organization organization);
    List<Event> getAllById(Long id);
    Organization updateOrganization(Long id, Organization organization);
    void deleteOrganization(Long id);
}

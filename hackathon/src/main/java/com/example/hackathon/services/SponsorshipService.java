package com.example.hackathon.services;

import com.example.hackathon.entities.Sponsorship;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SponsorshipService {
    List<Sponsorship> getAllSponsorships();
    Sponsorship getSponsorshipById(Long id);
    Sponsorship saveSponsorship(Sponsorship sponsorship);
    Sponsorship updateSponsorship(Long id, Sponsorship updatedSponsorship);
    void deleteSponsorship(Long id);
}

package com.example.hackathon.services;

import com.example.hackathon.entities.Sponsor;

import java.util.List;

public interface SponsorService {
    List<Sponsor> getAllSponsors();
    Sponsor getSponsorById(Long id);
    Sponsor saveSponsor(Sponsor sponsor);
    Sponsor updateSponsor(Long id, Sponsor updatedSponsor);
    void deleteSponsor(Long id);
}

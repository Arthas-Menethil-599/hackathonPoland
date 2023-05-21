package com.example.hackathon.services;

import com.example.hackathon.entities.Sponsor;
import com.example.hackathon.repositories.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {
    private final SponsorRepository sponsorRepository;

    public SponsorServiceImpl(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor getSponsorById(Long id) {
        Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        return optionalSponsor.orElse(null);
    }

    @Override
    public Sponsor saveSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor updateSponsor(Long id, Sponsor updatedSponsor) {
        Optional<Sponsor> optionalSponsor = sponsorRepository.findById(id);
        if (optionalSponsor.isPresent()) {
            Sponsor sponsor = optionalSponsor.get();
            sponsor.setName(updatedSponsor.getName());
            sponsor.setDescription(updatedSponsor.getDescription());
            return sponsorRepository.save(sponsor);
        }
        return null;
    }

    @Override
    public void deleteSponsor(Long id) {
        sponsorRepository.deleteById(id);
    }
}

package com.example.hackathon.services;

import com.example.hackathon.entities.Sponsorship;
import com.example.hackathon.repositories.SponsorshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorshipServiceImpl implements SponsorshipService {

    private final SponsorshipRepository sponsorshipRepository;

    public SponsorshipServiceImpl(SponsorshipRepository sponsorshipRepository) {
        this.sponsorshipRepository = sponsorshipRepository;
    }

    @Override
    public List<Sponsorship> getAllSponsorships() {
        return sponsorshipRepository.findAll();
    }

    @Override
    public Sponsorship getSponsorshipById(Long id) {
        Optional<Sponsorship> optionalSponsorship = sponsorshipRepository.findById(id);
        return optionalSponsorship.orElse(null);
    }

    @Override
    public Sponsorship saveSponsorship(Sponsorship sponsorship) {
        return sponsorshipRepository.save(sponsorship);
    }

    @Override
    public Sponsorship updateSponsorship(Long id, Sponsorship updatedSponsorship) {
        Optional<Sponsorship> optionalSponsorship = sponsorshipRepository.findById(id);
        if (optionalSponsorship.isPresent()) {
            Sponsorship sponsorship = optionalSponsorship.get();
            sponsorship.setTitle(updatedSponsorship.getTitle());
            sponsorship.setDescription(updatedSponsorship.getDescription());
            sponsorship.setDiscount(updatedSponsorship.getDiscount());
            sponsorship.setLevelNumber(updatedSponsorship.getLevelNumber());
            return sponsorshipRepository.save(sponsorship);
        }
        return null;
    }

    @Override
    public void deleteSponsorship(Long id) {
        sponsorshipRepository.deleteById(id);
    }
}

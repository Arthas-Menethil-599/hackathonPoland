package com.example.hackathon.services;

import com.example.hackathon.entities.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(Long id);
    Skill saveSkill(Skill skill);
    Skill updateSkill(Long id, Skill updatedSkill);
    void deleteSkill(Long id);
}

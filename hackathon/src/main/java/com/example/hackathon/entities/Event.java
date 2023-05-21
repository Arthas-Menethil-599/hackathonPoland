package com.example.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="events")
public class Event extends BaseEntity {
    private String title;
    private String description;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    private Organization organization;
    private Date fromDate;
    private Date untilDate;
    private Integer volunteersAmount;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Skill> skills;
    private String additionalRequirements;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Sponsor> sponsors;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Volunteer> volunteers;
}

package com.example.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sponsors")
public class Sponsor extends BaseEntity {

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Account account;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Sponsorship> sponsorships;
}

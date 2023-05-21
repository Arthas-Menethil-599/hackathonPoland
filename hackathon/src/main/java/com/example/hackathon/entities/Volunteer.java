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
@Table(name="volunteers")
public class Volunteer extends BaseEntity {

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Account account;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Skill> skills;
    private String interests;
    private Integer level;
    private Integer experiencePoints;
    @ManyToOne(fetch = FetchType.EAGER)
    private City city;
}

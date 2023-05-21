package com.example.hackathon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sponsorships")
public class Sponsorship extends BaseEntity {

    private String title;
    private String description;
    private Integer discount;
    private Integer levelNumber;
}

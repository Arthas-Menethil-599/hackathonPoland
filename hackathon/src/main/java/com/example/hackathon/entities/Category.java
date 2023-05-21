package com.example.hackathon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category extends BaseEntity {

    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    List<Skill> skills;
}

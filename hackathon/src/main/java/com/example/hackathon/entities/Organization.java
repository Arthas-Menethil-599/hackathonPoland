package com.example.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="organizations")
public class Organization extends BaseEntity {
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Account account;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

}

package com.example.hackathon.entities;

import com.example.hackathon.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Account extends BaseEntity {
    @Column(unique=true)
    private String username;
    private String password;
    private String email;
    private String contactNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


}
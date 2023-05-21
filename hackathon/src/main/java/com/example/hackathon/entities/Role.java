package com.example.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="roles")
public class Role extends BaseEntity implements GrantedAuthority {

    private String role;
    @Override public String getAuthority() {
        return getRole();
    }
}

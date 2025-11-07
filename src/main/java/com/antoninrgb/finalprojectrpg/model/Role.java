package com.antoninrgb.finalprojectrpg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.LAZY;

/**
 * Entity class for representing a Role in the database
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Getter @Setter private String name;
    @Getter @Setter @ManyToMany(mappedBy = "roles", fetch = LAZY) @JsonIgnore private Collection<User> users = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }
}

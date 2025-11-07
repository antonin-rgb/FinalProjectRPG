package com.antoninrgb.finalprojectrpg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter @ManyToMany(fetch = EAGER) @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles = new ArrayList<>();
    @Getter @Setter @OneToMany(mappedBy = "user") private List<Avatar> avatars = new ArrayList<>();
    @Getter @Setter private int activeAvatarId;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

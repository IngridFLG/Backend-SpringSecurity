package org.practica.springbootspringsecurity.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Column(name = "is_enable")
    private boolean isEnabled;

    @Column(name = "account_Non_Expired")
    private boolean accountNonExpired;

    @Column(name = "account_Non_Locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_Non_Expired")
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
}

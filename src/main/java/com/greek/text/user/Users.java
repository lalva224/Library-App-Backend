package com.greek.text.user;

import jakarta.persistence.*;

import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @Column(unique = true,columnDefinition = "varchar(255) default null")
    private String email;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(columnDefinition = "varchar(255) default null")
    private String address;
    @Column(columnDefinition = "varchar(255) default null")
    private String homeAddress;

    private String rememberToken;
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;



    @Enumerated(EnumType.STRING)
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @OneToMany(targetEntity = CreditCardDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private List<CreditCardDetails> cards;

}

package com.example.Task_SpringBoot.entities;

import com.example.Task_SpringBoot.dto.UserDto;
import com.example.Task_SpringBoot.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private UserRole userRole;

    // Implementations of UserDetails methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert userRole to a collection of authorities if needed
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }
    @Override
    public String getPassword() {
        return password; // Return the password field
    }

    @Override
    public String getUsername() {
        return email; // Typically, username is an email or name
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can add custom logic for expiration
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Custom logic can go here for locked accounts
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Custom logic for expired credentials
    }

    @Override
    public boolean isEnabled() {
        return true; // Custom logic for enabling/disabling users
    }

    public UserDto getUserDto()
    {
    UserDto userDto = new UserDto();
    userDto.setId(id);
    userDto.setName(name);
    userDto.setEmail(email);
    userDto.setUserRole(userRole);
    return userDto;
    }


}

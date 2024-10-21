package com.example.Task_SpringBoot.services.admin;

import com.example.Task_SpringBoot.dto.UserDto;
import com.example.Task_SpringBoot.entities.User;
import com.example.Task_SpringBoot.enums.UserRole;
import com.example.Task_SpringBoot.repositries.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminserviceImpl implements AdminService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll() // Retrieves all users from the repository
                .stream()                   // Converts the list of users to a stream
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE) // Filters only users with role EMPLOYEE
                .map(User::getUserDto)      // Maps each filtered user to a UserDto
                .collect(Collectors.toList()); // Collects the result into a list
    }
}

x

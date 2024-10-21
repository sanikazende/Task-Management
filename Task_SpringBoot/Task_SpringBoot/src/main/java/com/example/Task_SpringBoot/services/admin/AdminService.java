package com.example.Task_SpringBoot.services.admin;

import com.example.Task_SpringBoot.dto.UserDto;

import java.util.List;
public interface AdminService {
    List<UserDto> getUsers();
}

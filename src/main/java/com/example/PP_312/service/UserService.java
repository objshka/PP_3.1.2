package com.example.PP_312.service;

import com.example.PP_312.model.User;

import java.util.List;

public interface UserService {
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public void addUser(User user);
    public void updateUser(User user);
    public User getUserById(int id);
}

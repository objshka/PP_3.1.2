package com.example.PP_312.controller;

import com.example.PP_312.model.User;
import com.example.PP_312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/new_user")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping(value = "/new_user")
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping(value = "/edit")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}

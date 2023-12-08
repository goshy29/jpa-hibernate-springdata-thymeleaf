package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String listStudents(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("users", users);
        return "students";
    }

    @GetMapping("/user/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "studentEdit";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute Users users, Model model) {
        userService.save(users);
        //model.addAttribute("users", userService.findAll());
        return "redirect:/";
    }

    @GetMapping("/user/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "studentEdit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable int id, @ModelAttribute Users users, Model model) {
        userService.save(users);
        //model.addAttribute("users", userService.findAll());
        return "redirect:/";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable int id, Model model) {
        userService.deleteById(id);
        return "redirect:/";
    }
}

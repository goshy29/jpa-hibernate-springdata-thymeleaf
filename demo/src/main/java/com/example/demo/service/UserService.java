package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(int id) {
        return usersRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public void deleteById(int id) {
        usersRepository.deleteById(id);
    }
}

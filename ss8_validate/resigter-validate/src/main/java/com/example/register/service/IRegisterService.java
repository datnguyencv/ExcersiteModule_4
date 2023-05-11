package com.example.register.service;

import com.example.register.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRegisterService {
    List<User> getAll();

    void create(User user);

    void update(User user);

    void removeById(Integer id);

}

package com.example.register.service;

import com.example.register.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IRegisterService {

    void create(User user);


}

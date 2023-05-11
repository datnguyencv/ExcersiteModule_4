package com.example.register.service.impl;

import com.example.register.model.User;
import com.example.register.repository.IRegisterRepository;
import com.example.register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    private IRegisterRepository registerRepository;

    @Override
    public void create(User user) {
        registerRepository.save(user);
    }

}

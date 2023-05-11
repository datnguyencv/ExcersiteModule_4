package com.example.register.service.impl;

import com.example.register.model.User;
import com.example.register.repository.IRegisterRepository;
import com.example.register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    IRegisterRepository registerRepository;

    @Override
    public List<User> getAll() {
        return registerRepository.findAll();
    }

    @Override
    public void create(User user) {
        registerRepository.save(user);
    }

    @Override
    public void update(User user) {
        registerRepository.save(user);
    }

    @Override
    public void removeById(Integer id) {
        registerRepository.deleteById(id);
    }
}

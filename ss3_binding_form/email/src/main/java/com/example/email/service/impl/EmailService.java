package com.example.email.service.impl;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;
import com.example.email.repository.imppl.EmailRepository;
import com.example.email.service.IEmailService;

import java.util.List;

public class EmailService implements IEmailService {
    IEmailRepository emailRepository = new EmailRepository();

    @Override
    public List<Email> findAllEmail() {
        return this.emailRepository.findAllEmail();
    }

    @Override
    public void updateEmail(int id, Email email) {
        this.emailRepository.updateEmail(id, email);
    }

    @Override
    public Email findById(int id) {
        return this.emailRepository.findMyId(id);
    }
}

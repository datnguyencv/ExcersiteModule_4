package com.example.email.repository;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAllEmail();

    void updateEmail(int id, Email email);

    Email findMyId(int id);
}

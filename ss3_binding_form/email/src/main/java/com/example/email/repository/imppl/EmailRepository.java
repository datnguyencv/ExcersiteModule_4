package com.example.email.repository.imppl;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailRepository implements IEmailRepository {
    private static final Map<Integer,Email> emails = new HashMap<>();

    static {
        emails.put(1,new Email(1,"English",25,false,"Thor"));
        emails.put(2,new Email(2,"Vietnamese",5,true,"King"));
        emails.put(3,new Email(3,"Japanese",15,false,"Asgard"));
        emails.put(4,new Email(4,"Chinese",10,false,"Dat"));
    }
    @Override
    public List<Email> findAllEmail() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public void updateEmail(int id, Email email) {
        emails.put(id, email);
    }

    @Override
    public Email findMyId(int id) {
        return emails.get(id);
    }
}

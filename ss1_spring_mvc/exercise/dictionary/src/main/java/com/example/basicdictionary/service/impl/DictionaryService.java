package com.example.basicdictionary.service.impl;

import com.example.basicdictionary.repository.IDictionaryRepository;
import com.example.basicdictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public String translate(String english) {
        return this.iDictionaryRepository.translate(english);
    }
}


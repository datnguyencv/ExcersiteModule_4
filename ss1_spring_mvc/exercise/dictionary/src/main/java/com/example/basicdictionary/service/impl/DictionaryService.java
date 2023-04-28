package com.example.basicdictionary.service.impl;

import com.example.basicdictionary.repository.IDictionaryRepository;
import com.example.basicdictionary.repository.impl.DictionaryRepository;
import com.example.basicdictionary.service.IDictionaryService;

public class DictionaryService implements IDictionaryService {
    IDictionaryRepository iDictionaryRepository = new DictionaryRepository();

    @Override
    public String translate(String english) {
        return this.iDictionaryRepository.translate(english);
    }
}


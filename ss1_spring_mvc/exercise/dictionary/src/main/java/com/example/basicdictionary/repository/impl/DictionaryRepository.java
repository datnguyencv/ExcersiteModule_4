package com.example.basicdictionary.repository.impl;

import com.example.basicdictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("school", "Trường học");
        dictionary.put("attack", "Tấn công");
        dictionary.put("study", "Học bài");
        dictionary.put("motorbike", "Xe máy");
        dictionary.put("computer", "Máy tính");
    }

    @Override
    public String translate(String english) {
        String vietnamese;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (english.equals(entry.getKey())) {
                vietnamese = entry.getValue();
                return vietnamese;
            }
        }
        return "No available in database";
    }
}

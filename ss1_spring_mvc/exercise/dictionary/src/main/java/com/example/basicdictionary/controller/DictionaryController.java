package com.example.basicdictionary.controller;

import com.example.basicdictionary.service.IDictionaryService;
import com.example.basicdictionary.service.impl.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    public static IDictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/")
    public String showFormTranslate() {
        return "dictionary";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        model.addAttribute("result", dictionaryService.translate(english));
        model.addAttribute("english", english);
        return "dictionary";
    }
}

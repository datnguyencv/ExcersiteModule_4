package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("/")
    public String showFormConvert() {
        return "convert";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam double usd, @RequestParam double vnd, Model model) {
        model.addAttribute("result", this.convertService.convert(usd, vnd));
        return "convert";
    }
}

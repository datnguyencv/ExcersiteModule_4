package com.example.spice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @GetMapping("/home")
    public String home() {
        return "sandwich";
    }

    @PostMapping("/sandwich-condiments")
    public String save(@RequestParam(value = "condiments", required = false,
            defaultValue = "No condiments") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "sandwich";
    }
}

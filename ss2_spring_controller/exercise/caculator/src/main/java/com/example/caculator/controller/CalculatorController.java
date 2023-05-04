package com.example.caculator.controller;

import com.example.caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "number-one", required = false,
                                        defaultValue = "0") int numberOne,
                             @RequestParam(value = "number-two", required = false,
                                        defaultValue = "0") int numberTwo,
                             @RequestParam String action, Model model) {
        double result = 0;
        if (action == null) action = "";
        switch (action) {
            case "addition":
                result = calculatorService.addition(numberOne, numberTwo);
                break;
            case "subtraction":
                result = calculatorService.subtraction(numberOne, numberTwo);
                break;
            case "multiplication":
                result = calculatorService.multiplication(numberOne, numberTwo);
                break;
            case "division":
                if (numberTwo == 0) {
                    model.addAttribute("result", "Infinity");
                    break;
                }
                result = calculatorService.division(numberOne, numberTwo);
                break;
            default:
        }
        model.addAttribute("number-one", numberOne);
        model.addAttribute("number-two", numberTwo);
        model.addAttribute("action", action);
        model.addAttribute("result", result);

        return "index";
    }

}

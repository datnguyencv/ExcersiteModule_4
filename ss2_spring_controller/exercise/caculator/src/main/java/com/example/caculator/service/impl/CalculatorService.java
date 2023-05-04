package com.example.caculator.service.impl;

import com.example.caculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public int addition(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public int subtraction(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    @Override
    public int multiplication(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public double division(double numberOne, double numberTwo) {
        return numberOne / numberTwo;
    }
}

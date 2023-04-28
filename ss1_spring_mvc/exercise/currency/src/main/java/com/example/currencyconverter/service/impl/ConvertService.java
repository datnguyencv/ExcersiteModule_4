package com.example.currencyconverter.service.impl;

import com.example.currencyconverter.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public Double convert(Double vnd, Double usd) {
        return vnd * usd;
    }
}

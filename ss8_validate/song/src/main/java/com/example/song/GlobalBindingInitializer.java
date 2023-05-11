package com.example.song;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalBindingInitializer {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // trim dữ liệu của tất cả các trường dữ liệu String trước khi validate
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}


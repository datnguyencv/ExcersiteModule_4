package com.example.register.controller;

import com.example.register.dto.UserDto;
import com.example.register.model.User;
import com.example.register.service.IRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("userDto", new UserDto());
        return ("/form");
    }

    @PostMapping("create")
    public String getCreateForm(@Valid @ModelAttribute("UserDto") UserDto userDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "form";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.registerService.create(user);
        redirectAttributes.addFlashAttribute("msg", "messages");
        return "redirect:/index";
    }
}

package com.example.SpringStart.login.controller;

import com.example.SpringStart.login.domain.model.GroupOrder;
import com.example.SpringStart.login.domain.model.SignupForm;
import com.example.SpringStart.login.domain.model.User;
import com.example.SpringStart.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    private Map<String, String> radioMarriage;

    private Map<String, String> initRadioMarriage(){
        Map<String, String> radio = new LinkedHashMap<>();

        radio.put("Married", "true");
        radio.put("Unmarried", "false");

        return radio;
    }

    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model){

        radioMarriage = initRadioMarriage();

        model.addAttribute("radioMarriage", radioMarriage);

        return "login/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute SignupForm form, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return getSignUp(form, model);
        }

        System.out.println(form);
        System.out.println(form.getUserName());

        User user = new User();

        user.setUserId(form.getUserId());
        user.setPassword(form.getPassword());
        user.setUserName(form.getUserName());
        user.setBirthday(form.getBirthday());
        user.setAge(form.getAge());
        user.setMarriage(form.isMarriage());
        user.setRole("ROLE_GENERAL");

        boolean result = userService.insert(user);

        if(result == true) {
            System.out.println("insert success");
        }else{
            System.out.println("insert error");
        }

        return "redirect:/login";

    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){ //principal has all the information on the user logged in
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "secure";
    }

    @RequestMapping("/")
    public String index(Principal principal, Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login?logout=true"; //redirect is a keyword redirecting to @RequestMapping("/login") while ?logout is changing logout to true
    }
}

package com.learnings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/public")
    public String publicPage(Model model) {
        model.addAttribute("message", "This is a public page. No authentication required.");
        return "public";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to the home page!");
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

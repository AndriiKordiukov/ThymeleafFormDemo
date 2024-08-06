package com.kor.springdemo.controllers;

import com.kor.springdemo.Models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/")
    public String saveStudent(@ModelAttribute("student") Student student,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Errors!");
            System.out.println(bindingResult.getAllErrors());
            return ""; // TRY AGAIN
        }
        System.out.println(student);
        return "success"; // Redirect to a success page
    }

    @GetMapping("/success")
    public String successPage(@ModelAttribute("student") Student student) {
        return "success"; // Assuming a Thymeleaf template
    }
    @GetMapping("/invalid")
    public String invalidPage(@ModelAttribute("student") Student student) {
        return "invalid"; // Assuming a Thymeleaf template
    }
}

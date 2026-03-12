package com.org.project.application.controller;

import com.org.project.application.entity.Admin;
import com.org.project.application.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/api/coutomers")
    public  String  get(){
        return customerRepository.findAll().toString();

    }
    @GetMapping("/{admin}")
    public  Admin  getByName(@PathVariable String admin){
        return new Admin("01","yasiru","123");

    }
    @GetMapping("/silva/*/*")
    public  String  getAny(){
        return "after everything";
    }

    @PostMapping("/silva/")
    public boolean SaveSomting(String somting){
        return true;
    }

}

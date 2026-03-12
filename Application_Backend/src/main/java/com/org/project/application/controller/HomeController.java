package com.org.project.application.controller;

import com.org.project.application.entity.Admin;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HomeController {

    @GetMapping("/api/coutomers")
    public  String  get(){
        return "";

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

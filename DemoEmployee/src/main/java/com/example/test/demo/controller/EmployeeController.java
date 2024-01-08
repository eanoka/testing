package com.example.test.demo.controller;

import com.example.test.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @GetMapping("/file")
    public void saveEmployeeDetails(){
        try{
            service.generateFile();
        }catch (Exception e){
            System.out.println("Error while saving the file");
        }
    }

}

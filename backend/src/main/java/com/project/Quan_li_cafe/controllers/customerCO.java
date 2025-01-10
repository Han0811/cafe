package com.project.Quan_li_cafe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.Quan_li_cafe.models.customerEN;
import com.project.Quan_li_cafe.dtos.customerDTO;
import com.project.Quan_li_cafe.repositories.customerRE;
import com.project.Quan_li_cafe.service.customer.customerSE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/custom")
public class customerCO {
    @Autowired
    private customerSE customerSE;

    @Autowired
    private customerRE customerRE;

    @GetMapping("/list")
    public List<customerEN> list(){
        return customerRE.findAll();
    }

    @PostMapping("/add")
    public customerEN addCus(@RequestBody customerDTO customerDTO) {
        return customerSE.add(customerDTO);
    }

    @GetMapping("/oneList")
    public customerEN oneList(@RequestParam String phone){
        return customerSE.findOne(phone);
    }
}


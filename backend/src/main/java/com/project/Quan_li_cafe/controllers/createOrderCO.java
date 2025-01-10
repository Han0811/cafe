package com.project.Quan_li_cafe.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Quan_li_cafe.service.createOrder;
import com.project.Quan_li_cafe.dtos.createOrderDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/createOrder")
public class createOrderCO {
    @Autowired
    private createOrder createOrder;

    @PostMapping("/add")
    public void addOrder(@RequestBody String token) {
        createOrder.saveOrderFromRedisToDatabase(token);
    }
}

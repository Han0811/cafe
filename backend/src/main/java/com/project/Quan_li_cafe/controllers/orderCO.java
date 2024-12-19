package com.project.Quan_li_cafe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.Quan_li_cafe.models.oderEN;
import com.project.Quan_li_cafe.dtos.orderDTO;
import com.project.Quan_li_cafe.repositories.orderRE;
import com.project.Quan_li_cafe.service.order.orderSE;


@RestController
@RequestMapping("/order")
public class orderCO {
    @Autowired
    private orderRE orderRE;

    @Autowired
    private orderSE orderSE1;
    @GetMapping("/list")
    public List<oderEN> list(){

        return orderSE1.list();
    }

    @PostMapping("/add")
    public oderEN addOrder(@RequestBody orderDTO orderDTO){
        return orderSE1.add(orderDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam long id){
        return orderSE1.delete(id);
    }

    @GetMapping("/oneorder")
    public oderEN getOne(@RequestParam long id){
        return orderSE1.findOne(id);
    }

}

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

import com.project.Quan_li_cafe.service.category.categorySE;
import com.project.Quan_li_cafe.models.categoryEN;



@RestController
@RequestMapping("/category")
public class categoryCO {
    @Autowired
    private categorySE categorySE;

    @GetMapping("/list")
    public List<categoryEN> list(){
        return categorySE.list();
    }
}

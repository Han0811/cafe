package com.project.Quan_li_cafe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Quan_li_cafe.models.staffEN;
import com.project.Quan_li_cafe.repositories.staffRE;
import com.project.Quan_li_cafe.service.staff.staffSE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/staff")
public class staffCO {
    @Autowired
    private staffSE staffSE;

    @GetMapping("/list")
    public List<staffEN> getAllStaff(){
        return staffSE.getAll();
    }
}

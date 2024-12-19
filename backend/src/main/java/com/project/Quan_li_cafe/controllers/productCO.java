package com.project.Quan_li_cafe.controllers;

import java.util.ArrayList;
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

import com.project.Quan_li_cafe.dtos.newproductDTO;
import com.project.Quan_li_cafe.models.productEN;
import com.project.Quan_li_cafe.repositories.productRE;
import com.project.Quan_li_cafe.service.product.productSE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class productCO {
    @Autowired
    private productRE productRE;

    @Autowired 
    private productSE productSE;

    @GetMapping("/data")
    public List<productEN> getAllProducts() {
        return productSE.list();
    }
    
    
    @PostMapping("/data/batch")
    public List<productEN> createProducts(@RequestBody List<newproductDTO> newproductDTOs) {
        List<productEN> products = new ArrayList<>();
        newproductDTOs.forEach(newproductDTO -> {
            products.add(convertToProductEN(newproductDTO)); 
        });
        return productRE.saveAll(products); 
    }

    private productEN convertToProductEN(newproductDTO dto) {
        productEN product = new productEN();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setTitle(dto.getTitle());
        product.setDetail(dto.getDetail());
        return product;
    }

    @DeleteMapping("/{name}")
    private boolean deletePro(@RequestParam String name){
        return productSE.deletePro(name);
    }

    @GetMapping("/cate/{id}")
    private List<productEN> ProCate(@PathVariable int id){
        return productRE.findByCategory_Id(id);
    }
}    

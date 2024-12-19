package com.project.Quan_li_cafe.service.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.dtos.newproductDTO;
import com.project.Quan_li_cafe.models.productEN;
import com.project.Quan_li_cafe.repositories.productRE;

@Service
public class productSE implements productIN{
    @Autowired
    private productRE product;

    @Override
    public productEN addPro(newproductDTO newproductDTO) {
       productEN result = new productEN();
       result.setId(newproductDTO.getId());
       result.setName(newproductDTO.getName());
       result.setTitle(newproductDTO.getTitle());
       result.setPrice(newproductDTO.getPrice());
       result.setDetail(newproductDTO.getDetail());

       return product.save(result);
    }

    @Override
    public boolean deletePro(String name) {
        productEN result = product.findByName(name);
        
        if(result != null){
            product.delete(result);
            return true;
        }
        return false;
    }

    @Override
    public productEN fixPro(String name, newproductDTO newproductDTO) {
        productEN result = product.findByName(name);

        if(result == null){
            throw new RuntimeException("Sản phẩm không tồn tại.");
        }
        result.setId(newproductDTO.getId());
        result.setName(newproductDTO.getName());
        result.setTitle(newproductDTO.getTitle());
        result.setPrice(newproductDTO.getPrice());
        result.setDetail(newproductDTO.getDetail());
 
        return product.save(result);
        
    }

    @Override
    public List<productEN> list() {
       return product.findAll();
    }

    @Override
    public productEN findOnePro(String name) {
        return product.findByName(name);
    }

}

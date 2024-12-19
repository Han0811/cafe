package com.project.Quan_li_cafe.service.product;

import java.util.List;

import com.project.Quan_li_cafe.dtos.newproductDTO;
import com.project.Quan_li_cafe.models.productEN;

public interface productIN {
    productEN addPro(newproductDTO newproductDTO);
    boolean deletePro(String name);
    productEN fixPro(String name, newproductDTO newproductDTO);
    List<productEN> list();
    productEN findOnePro(String name);
}

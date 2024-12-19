package com.project.Quan_li_cafe.service.customer;

import com.project.Quan_li_cafe.dtos.customerDTO;
import com.project.Quan_li_cafe.models.customerEN;

public interface customerIN {
    customerEN add(customerDTO customerDTO);
    customerEN findOne(String phone);
}

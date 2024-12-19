package com.project.Quan_li_cafe.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.dtos.customerDTO;
import com.project.Quan_li_cafe.models.customerEN;
import com.project.Quan_li_cafe.repositories.customerRE;

@Service
public class customerSE implements customerIN{
    @Autowired
    private customerRE customer;

    @Override
    public customerEN add(customerDTO customerDTO) {
        customerEN result = new customerEN();

        result.setName(customerDTO.getName());
        result.setMail(customerDTO.getMail());
        result.setPhone(customerDTO.getPhone());
        result.setAddress(customerDTO.getAddress());

        return customer.save(result);
    }

    @Override
    public customerEN findOne(String phone) {
        return customer.findByPhone(phone);
    }

}

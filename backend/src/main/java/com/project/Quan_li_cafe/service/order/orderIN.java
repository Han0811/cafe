package com.project.Quan_li_cafe.service.order;

import java.util.List;

import com.project.Quan_li_cafe.dtos.orderDTO;
import com.project.Quan_li_cafe.models.oderEN;

public interface orderIN {
    List<oderEN> list();
    boolean delete(long id);
    oderEN findOne(long id);
    oderEN add(orderDTO orderDTO); 
}

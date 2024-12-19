package com.project.Quan_li_cafe.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.dtos.orderDTO;
import com.project.Quan_li_cafe.models.oderEN;
import com.project.Quan_li_cafe.repositories.orderRE;

@Service
public class orderSE implements orderIN{
    @Autowired
    private orderRE order;

    @Override
    public List<oderEN> list() {
       return order.findAll();
    }

    @Override
    public boolean delete(long id) {
        oderEN result = order.findById(id);

        if(result != null){
            order.delete(result);
            return true;
        }
        return false;
    }

    @Override
    public oderEN findOne(long id) {
        return order.findById(id);
    }

    @Override
    public oderEN add(orderDTO orderDTO) {
       oderEN result = new oderEN();

       result.setCus(orderDTO.getCus());
       result.setStaff(orderDTO.getStaff());
       result.setDate(orderDTO.getDate());

       return order.save(result);
    }


}

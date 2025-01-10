package com.project.Quan_li_cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.project.Quan_li_cafe.dtos.createOrderDTO;
import com.project.Quan_li_cafe.models.customerEN;
import com.project.Quan_li_cafe.models.oderEN;
import com.project.Quan_li_cafe.models.order_detailEN;
import com.project.Quan_li_cafe.repositories.customerRE;
import com.project.Quan_li_cafe.repositories.orderRE;
import com.project.Quan_li_cafe.repositories.order_detailRE;
import com.project.Quan_li_cafe.repositories.productRE;
import com.project.Quan_li_cafe.repositories.staffRE;
import com.project.Quan_li_cafe.dtos.orderdetailDTO;
import com.project.Quan_li_cafe.service.TemporaryOrderStorage;
import com.project.Quan_li_cafe.models.productEN;
import com.project.Quan_li_cafe.models.staffEN;



@Service
public class createOrder {
    @Autowired
    private customerRE customerRE;

    @Autowired
    private orderRE orderRE;

    @Autowired
    private order_detailRE order_detailRE;

    @Autowired
    private productRE productRE;

    @Autowired
    private staffRE staffRE;

    @Autowired
    private TemporaryOrderStorage temporaryOrderStorage;

    @Transactional
    public void saveOrderFromRedisToDatabase(String token) {
        createOrderDTO dto = temporaryOrderStorage.getOcreateOrderDTO(token);
        if(dto != null) {
        customerEN customer = new customerEN();
        customer.setName(dto.getName());
        customer.setMail(dto.getMail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customerRE.save(customer);
    
        oderEN order = new oderEN();
        order.setCus(customerRE.findById(customer.getId()));
        order.setStaff(staffRE.findById(dto.getId_staff()));
        orderRE.save(order);
    
        for (orderdetailDTO item : dto.getOrderDetail()) {
            productEN product = item.getId_pro();
            order_detailEN orderDetail = new order_detailEN();
            orderDetail.setOrder(order); 
            orderDetail.setPro(product);
            orderDetail.setAmount(item.getAmount());
            order_detailRE.save(orderDetail);
        }
    }
}

}

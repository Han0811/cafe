package com.project.Quan_li_cafe.services.order_detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.models.order_detailEN;
import com.project.Quan_li_cafe.models.productEN;
import com.project.Quan_li_cafe.dtos.orderdetailDTO;
import com.project.Quan_li_cafe.repositories.order_detailRE;
import com.project.Quan_li_cafe.repositories.productRE;

@Service
public class order_detailSE {

    @Autowired
    private order_detailRE order_detailRE;

    // Thêm mới
    // public order_detailEN addOrderDetail(orderdetailDTO dto) {
    //     order_detailEN orderDetail = new order_detailEN();
    //     orderDetail.setOrder(dto.getId_order());
    //     orderDetail.setPro(dto.getId_pro());
    //     orderDetail.setAmount(dto.getAmount());
    //     return order_detailRE.save(orderDetail);
    // }

    // public void deleteOrderDetail(int id) {
    //     order_detailRE.deleteById(Long.valueOf(id));
    // }

    // public List<order_detailEN> getAllOrderDetails() {
    //     return order_detailRE.findAll();
    // }
}

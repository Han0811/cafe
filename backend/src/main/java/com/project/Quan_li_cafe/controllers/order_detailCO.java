package com.project.Quan_li_cafe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.Quan_li_cafe.models.order_detailEN;
import com.project.Quan_li_cafe.dtos.orderdetailDTO;
import com.project.Quan_li_cafe.repositories.order_detailRE;
import com.project.Quan_li_cafe.services.order_detail.order_detailSE;

@RestController
@RequestMapping("/detail")
public class order_detailCO {
    @Autowired
    private order_detailRE order_detailRE;

    @Autowired
    private order_detailSE order_detailSE;

    // Thêm mới
    // @PostMapping("/add")
    // public order_detailEN addOrderDetail(@RequestBody orderdetailDTO orderDetail) {
    //     return order_detailSE.addOrderDetail(orderDetail);
    // }

    // @DeleteMapping("/delete")
    // public void deleteOrderDetail(@PathVariable int id) {
    //     order_detailSE.deleteOrderDetail(id);
    // }

    // // Lấy danh sách chi tiết đơn hàng
    // @GetMapping("list")
    // public List<order_detailEN> getAllOrderDetails() {
    //     return order_detailSE.getAllOrderDetails();
    // }
}

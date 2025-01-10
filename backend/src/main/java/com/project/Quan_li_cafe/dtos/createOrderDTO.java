package com.project.Quan_li_cafe.dtos;

import com.project.Quan_li_cafe.dtos.orderdetailDTO;

import java.util.List;

public class createOrderDTO {
    private String name;
    private String mail;
    private String phone;
    private String address;
    private int id_staff;
    private List<orderdetailDTO> orderDetail;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_staff() {
        return this.id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public List<orderdetailDTO> getOrderDetail() {
        return this.orderDetail;
    }

    public void setOrderDetail(List<orderdetailDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

}

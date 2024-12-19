package com.project.Quan_li_cafe.dtos;

import com.project.Quan_li_cafe.models.oderEN;
import com.project.Quan_li_cafe.models.productEN;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class orderdetailDTO {
    private oderEN id_order;
    private productEN id_pro;
    private float price;
    private int amount;

    public oderEN getId_order() {
        return this.id_order;
    }

    public void setId_order(oderEN id_order) {
        this.id_order = id_order;
    }

    public productEN getId_pro() {
        return this.id_pro;
    }

    public void setId_pro(productEN id_pro) {
        this.id_pro = id_pro;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   
}

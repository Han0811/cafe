package com.project.Quan_li_cafe.dtos;

import com.project.Quan_li_cafe.models.oderEN;
import com.project.Quan_li_cafe.models.productEN;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class orderdetailDTO {
    private productEN id_pro;
    private int amount;

    public productEN getId_pro() {
        return this.id_pro;
    }

    public void setId_pro(productEN id_pro) {
        this.id_pro = id_pro;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   
}

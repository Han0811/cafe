package com.project.Quan_li_cafe.dtos;

import java.sql.Date;

import com.project.Quan_li_cafe.models.customerEN;
import com.project.Quan_li_cafe.models.staffEN;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class orderDTO {
    private customerEN cus;
    private staffEN staff;
    private Date date;

    public customerEN getCus() {
        return this.cus;
    }

    public void setCus(customerEN cus) {
        this.cus = cus;
    }

    public staffEN getStaff() {
        return this.staff;
    }

    public void setStaff(staffEN staff) {
        this.staff = staff;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

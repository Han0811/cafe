package com.project.Quan_li_cafe.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "order")
public class oderEN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private customerEN cus;

    @ManyToOne
    @JoinColumn(name = "id_staff")
    private staffEN staff;

    @Column(name = "order_time")
    private Date date;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

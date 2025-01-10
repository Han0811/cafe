package com.project.Quan_li_cafe.models;


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
@Table(name = "order_detail")
public class order_detailEN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private oderEN order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private productEN pro;

    public productEN getPro() {
        return this.pro;
    }

    public void setPro(productEN pro) {
        this.pro = pro;
    }

    @Column(name = "amount")
    private int amount;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public oderEN getOrder() {
        return this.order;
    }

    public void setOrder(oderEN order) {
        this.order = order;
    }

    
    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

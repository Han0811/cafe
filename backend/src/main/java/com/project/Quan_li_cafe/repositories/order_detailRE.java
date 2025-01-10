package com.project.Quan_li_cafe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.Quan_li_cafe.models.order_detailEN;
import com.project.Quan_li_cafe.models.productEN;

@Repository
public interface order_detailRE extends JpaRepository<order_detailEN, Long> {
    order_detailEN findById(int id);
}


package com.project.Quan_li_cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Quan_li_cafe.models.customerEN;


@Repository
public interface customerRE extends JpaRepository<customerEN, Long>{
    customerEN findById(int id);
    customerEN findByPhone(String phone);
}

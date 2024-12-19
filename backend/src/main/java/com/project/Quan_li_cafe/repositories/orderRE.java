package com.project.Quan_li_cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Quan_li_cafe.models.oderEN;



@Repository
public interface orderRE extends JpaRepository<oderEN, Long> {
    oderEN  findById(long id);
}

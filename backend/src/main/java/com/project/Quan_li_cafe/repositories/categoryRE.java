package com.project.Quan_li_cafe.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Quan_li_cafe.models.categoryEN;



@Repository
public interface categoryRE extends JpaRepository<categoryEN, Long> {
   categoryEN findByName(String name);
}

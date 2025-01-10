package com.project.Quan_li_cafe.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Quan_li_cafe.models.productEN;


@Repository
public interface productRE extends JpaRepository<productEN, Long>{
productEN findByName(String name);
List<productEN> findByCategory_Id(int id);
productEN findById(int id);
}

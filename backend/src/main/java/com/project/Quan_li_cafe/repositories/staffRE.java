package com.project.Quan_li_cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Quan_li_cafe.models.staffEN;

@Repository
public interface staffRE extends JpaRepository<staffEN, Long> {

}

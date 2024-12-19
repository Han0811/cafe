package com.project.Quan_li_cafe.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.models.categoryEN;

public interface categoryIN {
    List<categoryEN> list();
    categoryEN findCateName(String name);
}

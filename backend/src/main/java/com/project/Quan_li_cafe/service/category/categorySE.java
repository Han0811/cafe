package com.project.Quan_li_cafe.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.models.categoryEN;
import com.project.Quan_li_cafe.repositories.categoryRE;

@Service
public class categorySE implements categoryIN{

    @Autowired
    private categoryRE category;
    @Override
    public List<categoryEN> list() {
        return category.findAll();
    }
    @Override
    public categoryEN findCateName(String name1) {
        return category.findByName(name1);
    }

    

}

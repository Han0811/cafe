package com.project.Quan_li_cafe.service.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Quan_li_cafe.models.staffEN;
import com.project.Quan_li_cafe.repositories.staffRE;

@Service
public class staffSE {
    @Autowired
    private staffRE staffRE;

    public List<staffEN> getAll(){
        return staffRE.findAll();
    }
}

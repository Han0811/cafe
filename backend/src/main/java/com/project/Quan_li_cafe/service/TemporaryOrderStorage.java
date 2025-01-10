package com.project.Quan_li_cafe.service;

import java.util.concurrent.TimeUnit;
import java.util.UUID;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


import com.project.Quan_li_cafe.dtos.createOrderDTO;
import com.project.Quan_li_cafe.component.RedisTTLChecker;


@Service
public class TemporaryOrderStorage {
    @Autowired
    private RedisTemplate<String, createOrderDTO> redisTemplate;

    @Autowired
    private RedisTTLChecker redisTTLChecker;

    public String savecreateOrderDTO(createOrderDTO createOrderDTO) {
        String token = UUID.randomUUID().toString(); 
        redisTemplate.opsForValue().set(token, createOrderDTO, 5, TimeUnit.MINUTES); 
        return token;
    }

    public createOrderDTO getOcreateOrderDTO(String token) {
        return redisTemplate.opsForValue().get(token);
    }

    public void removecreateOrderDTO(String token) {
        redisTemplate.delete(token);
    }
}

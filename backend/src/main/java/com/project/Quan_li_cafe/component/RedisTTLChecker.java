package com.project.Quan_li_cafe.component;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.project.Quan_li_cafe.service.EmailService;
import com.project.Quan_li_cafe.service.TemporaryOrderStorage;
import com.project.Quan_li_cafe.dtos.createOrderDTO;

@Component
public class RedisTTLChecker {

    @Autowired
    private RedisTemplate<String, createOrderDTO> redisTemplate;

    @Autowired
    @Lazy
    private EmailService emailService;

    @Autowired
    @Lazy
    private TemporaryOrderStorage temporaryOrderStorage;

    // Kiểm tra TTL định kỳ mỗi giây
    @Scheduled(fixedRate = 1000) // Chạy mỗi giây
    public void checkTTL() {
        // Lấy tất cả các keys từ Redis
        Set<String> keys = redisTemplate.keys("*"); // "*" đại diện cho tất cả các keys

        if (keys != null) {
            for (String key : keys) {
                // Lấy TTL của key
                Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);

                if (ttl != null && ttl <= 5 && ttl > 0) {
                    // Nếu TTL còn dưới 5 giây, gửi thông báo
                        emailService.sendNotify(key);
                    }
                }
            }
        }
    }
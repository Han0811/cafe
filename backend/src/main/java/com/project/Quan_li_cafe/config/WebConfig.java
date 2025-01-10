package com.project.Quan_li_cafe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.project.Quan_li_cafe.dtos.createOrderDTO;
import com.project.Quan_li_cafe.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableScheduling
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    @Lazy
    private EmailService emailService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Áp dụng cho tất cả các route
            .allowedOrigins("http://localhost:3000") // Chỉ cho phép từ React frontend
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP được phép
            .allowedHeaders("*"); // Cho phép tất cả các header
    }

    @Bean
    public RedisTemplate<String, createOrderDTO> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, createOrderDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    @Bean
    public KeyExpirationEventMessageListener keyExpirationEventMessageListener(RedisMessageListenerContainer container) {
        return new KeyExpirationEventMessageListener(container) {
            @Override
            public void onMessage(org.springframework.data.redis.connection.Message message, byte[] pattern) {
                String expiredKey = message.toString();
                // emailService.sendNotify(expiredKey);
                System.out.println("Key expired: " + expiredKey);
            }
        };
    }

    
}

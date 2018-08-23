package com.imock.mmall.config;

import com.imock.mmall.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.net.UnknownHostException;

/**
 * TODO
 *
 * @author: Chen Kj
 * @date: 2018/8/23 11:23
 * @version: 1.0
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Product> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Product> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));

        return template;
    }
}

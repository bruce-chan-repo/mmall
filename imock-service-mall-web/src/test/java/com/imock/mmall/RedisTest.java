package com.imock.mmall;

import com.imock.mmall.entity.Product;
import com.imock.mmall.service.IProductService;
import com.imock.mmall.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * TODO
 *
 * @author: Chen Kj
 * @date: 2018/8/23 10:01
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private IProductService productService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate myRedisTemplate;


    /**
     * Redis五种数据类型
     * String[字符串]、List[列表]、Set[集合]、Hash[散列]、ZSet[有序集合]
     *
     **/
    @Test
    public void testStringRedisTemplate() {
        //stringRedisTemplate.opsForValue().set("name", "陈康敬");
        //String name = stringRedisTemplate.opsForValue().get("name");
        //System.out.println("name ==>" + name);
    }

    @Test
    public void testRedisTemplate() {
        /*List<String> names = new ArrayList<>();
        names.add("Bruce Lee");
        names.add("Fenda");
        names.add("lisal");
        names.add("oldchen");

        redisTemplate.opsForList().leftPushAll("mylist", names);*/

        /*List<String> names = redisTemplate.opsForList().range("mylist", 0, -1);
        for (String name : names) {
            System.out.println("name :==>> " + name);
        }*/
        /*Product detail = productService.detail(26);
        myRedisTemplate.opsForValue().set("product", detail);*/

        Product product = (Product) myRedisTemplate.opsForValue().get("product");
        System.out.println(product);
    }

}

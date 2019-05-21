package com.imock.mmall.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池
 * @author: Chen Kj
 * @date: 2019/4/1 12:43
 * @version: 1.0
 */
@ConfigurationProperties(prefix = "redis")
public class RedisPool {
    private static String ip;

    private static Integer port;

    private static Integer maxTotal;

    private static Integer maxIdle;

    private static Integer minIdle;

    private static Boolean testOnBorrow;

    private static Boolean testOnReturn;

    private static JedisPool jedisPool;


    private static void initConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setBlockWhenExhausted(true);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, ip, port, 1000 * 2);
    }

    static {
        initConfig();
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void returnResource(Jedis jedis) {
        jedisPool.returnResource(jedis);
    }

    public static void returnBrokeResource(Jedis jedis) {
        jedisPool.returnBrokenResource(jedis);
    }
}

package com.pony.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/28
 */
@Component("redisUtil")
public class RedisUtil {

    private static String host = "r-m5e8ab16bef6b9b4.redis.rds.aliyuncs.com";
    private static String password = "As12345678";
    private static int maxInlle = 200;
    private static int maxTotal = 300;
    private static int port = 6379;
    private static int timeout = 3000;
    public static JedisPool jedisPool = null;

//    private JedisPool getJedisPool() {
//        if (jedisPool == null) {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxIdle(maxInlle);
//            config.setMaxTotal(maxTotal);
//            config.setTestOnBorrow(false);
//            config.setTestOnReturn(false);
//            JedisPool jedisPool = new JedisPool(config, host, port, timeout, password);
//            return jedisPool;
//        }
//        return jedisPool;
//    }

//    public void destray() {
//        JedisPool jedisPool = getJedisPool();
//        if (jedisPool != null) {
//            jedisPool.destroy();
//        }
//    }
//
//    public Jedis getJedis() {
//        JedisPool jedisPool = getJedisPool();
//        if (jedisPool != null) {
//            return jedisPool.getResource();
//        }
//
//        return null;
//    }

//    /**
//     * set Object
//     */
//    public String setObject(String key, Object object) {
//        Jedis jedis = getJedis();
//        if (jedis != null) {
//            return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
//        }
//        return null;
//    }
//
//    /**
//     * get Object
//     */
//    public Object getObject(String key) {
//        Jedis jedis = getJedis();
//        if (jedis != null) {
//            byte[] value = jedis.get(key.getBytes());
//            return SerializeUtil.unserialize(value);
//        }
//        return null;
//    }
//
//    /**
//     * delete a key
//     **/
//    public boolean del(String key) {
//        Jedis jedis = getJedis();
//        return jedis != null && jedis.del(key.getBytes()) > 0;
//    }
}

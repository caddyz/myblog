package com.kaiser.blog.config;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName RedisCacheMybatis
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/29 20:12
 * @Version 1.0
 **/
public class RedisCacheMybatis implements Cache {
    private String id;
    private static Logger logger = LoggerFactory.getLogger(RedisCacheMybatis.class);
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public RedisCacheMybatis(String id) {
        if(id == null){
            throw new IllegalArgumentException("cache instance require id");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if(redisTemplate == null){
            redisTemplate = (RedisTemplate<String, Object>) SpringContextHolder.getApplicationContext().getBean("redisJsonTemplate");
        }
        if(value != null){
            redisTemplate.opsForValue().set(key.toString(),value);
        }
    }

    @Override
    public Object getObject(Object key) {
        try{
            if(key != null){
                redisTemplate.opsForValue().get(key);
            }
        }catch (Exception e){
            logger.error("缓存出错");
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        if(key != null){
            redisTemplate.delete(key.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        logger.debug("清除缓存");
        if(redisTemplate == null){
            redisTemplate = (RedisTemplate<String, Object>)SpringContextHolder.getApplicationContext().getBean("redisJsonTemplate");
        }
        Set<String> keys = redisTemplate.keys("*" + this.id + "*");
        if(!CollectionUtils.isEmpty(keys)){
            redisTemplate.delete(keys);
        }
    }

    @Override
    public int getSize() {
        return redisTemplate.execute((RedisCallback<Long>) RedisServerCommands::dbSize).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.lock;
    }
}

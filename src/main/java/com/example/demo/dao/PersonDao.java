package com.example.demo.dao;

import com.example.demo.meta.person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.core.ValueOperations;

import org.springframework.stereotype.Repository;


@Repository

public class PersonDao {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    //下面这种方式未调通
    //@Resource(name = "redisTemplate")
    //ValueOperations<Object, Object> valOps;
    public void save(person person) {
        ValueOperations<Object, Object> valOps = redisTemplate.opsForValue();
        valOps.set(person.getId(), person);
    }

    public person getPerson(String id) {
        ValueOperations<Object, Object> valOps = redisTemplate.opsForValue();
        return (person) valOps.get(id);
    }

}
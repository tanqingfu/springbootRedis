package com.example.demo.Controller;




import javax.annotation.Resource;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.data.redis.core.ValueOperations;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController

public class StringRedisController {

protected static Logger logger=LoggerFactory.getLogger(StringRedisController.class);
    @Autowired StringRedisTemplate stringRedisTemplate;
    //下面这种方式未调通
    // @Resource(name="stringRedisTemplate")
    // ValueOperations<String,String> valOpsStr;
    @RequestMapping("set")
    public String setKeyAndValue(String key,String value){
        logger.debug("访问set:key={},value={}",key,value);
        ValueOperations valOpsStr = stringRedisTemplate.opsForValue();
        valOpsStr.set(key,value);
        return "Set Ok";
    }
    @RequestMapping("get")
    public Object getKey(String key){
        logger.debug("访问get:key={}",key);
        ValueOperations valOpsStr = stringRedisTemplate.opsForValue();
        return valOpsStr.get(key);
    }

}
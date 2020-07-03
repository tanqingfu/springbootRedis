package com.example.demo.Controller;

import com.example.demo.dao.PersonDao;
import com.example.demo.meta.person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectRedisController {

    protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);
    @Autowired PersonDao personDao;

    @RequestMapping("/setPerson")
    public void set(String id,String name,Integer age){
        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);
        person person=new person(id,name,age);
        personDao.save(person);
    }

    @RequestMapping("/getPerson")
    public person getPerson(String id){
        return personDao.getPerson(id);
    }
}


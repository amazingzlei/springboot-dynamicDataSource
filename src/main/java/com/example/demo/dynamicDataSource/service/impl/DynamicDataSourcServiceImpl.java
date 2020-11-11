package com.example.demo.dynamicDataSource.service.impl;

import com.example.demo.common.annotation.DataBase;
import com.example.demo.dynamicDataSource.dao.PersonDao;
import com.example.demo.dynamicDataSource.pojo.Person;
import com.example.demo.dynamicDataSource.service.DynamicDataSourcService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Component
public class DynamicDataSourcServiceImpl implements DynamicDataSourcService {

    @Resource
    private PersonDao personDao;
    // 注意用@Transactional修饰方法时，自调用会有问题，需要从容器获取自身的bean，然后调用对应的方法
    @Resource
    private DynamicDataSourcService dynamicDataSourcService;

    @Transactional
    @DataBase
    @Override
    public void queryUsers() {
        for (int i = 0; i < 5; i++){
            Person person = new Person();
            person.setId(100 + i);
            person.setName(String.valueOf(100 + i));
            person.setAddress("南京");
            person.setPhone("123");
            person.setTimestamp(new Timestamp(System.currentTimeMillis()));
            insertPerson(person);
        }
    }

    @DataBase
    @Override
    public void queryUsersFromDb2(){
        Person people = personDao.queryUserById(1);
        System.out.println(people);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DataBase
    @Override
    public void insertPerson(Person person) {
        personDao.insertUser(person);
        if(person.getId() == 104){
            int i = 1/0;
        }
    }
}

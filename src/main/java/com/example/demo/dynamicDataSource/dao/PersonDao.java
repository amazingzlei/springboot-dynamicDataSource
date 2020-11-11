package com.example.demo.dynamicDataSource.dao;

import com.example.demo.dynamicDataSource.pojo.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonDao {
    List<Person> queryUsers();

    Person queryUserById(Integer id);

    int insertUser(Person person);
}

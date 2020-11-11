package com.example.demo.dynamicDataSource.service;

import com.example.demo.dynamicDataSource.pojo.Person;
import org.springframework.stereotype.Service;

@Service
public interface DynamicDataSourcService {
    void queryUsers();

    void queryUsersFromDb2();

    void insertPerson(Person person);
}

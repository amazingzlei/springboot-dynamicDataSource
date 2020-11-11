package com.example.demo.dynamicDataSource.controller;

import com.example.demo.dynamicDataSource.service.DynamicDataSourcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class DynamicDataSourceController {

    @Resource
    private DynamicDataSourcService dynamicDataSourcService;

    @GetMapping("/queryUser")
    @ResponseBody
    public void queryUser(){
        dynamicDataSourcService.queryUsers();
    }

}

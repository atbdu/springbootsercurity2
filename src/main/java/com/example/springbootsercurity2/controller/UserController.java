package com.example.springbootsercurity2.controller;

import com.example.springbootsercurity2.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private Person person;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    @RequestMapping("/tologin")
    public String login(){
        int i=0;
        String demo1 = name;
        int age2 = age;
        System.out.println(demo1+age2);
        System.out.println("==================>"+person.getName()+person.getAge());
        return "login";
    }
    @RequestMapping("/toIndex")
    public String toIndex1(){
        return "index1";
    }
    @RequestMapping("/toFialed")
    public String toFialed(){
        return "index3";
    }
}

package com.example.demospringservice.service;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component(value = "helloService")
@WebService
public class HelloService {

    @WebMethod
    public String sayHello(String name){
        return String.format("hello,%s",name);
    }
}

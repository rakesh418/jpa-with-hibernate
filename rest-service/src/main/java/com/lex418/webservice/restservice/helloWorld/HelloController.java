package com.lex418.webservice.restservice.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello");
    }

    @GetMapping("/hello-world-bean/{id}")
    public HelloWorldBean helloWorldBeanPathvariable(@PathVariable String id){
        return new HelloWorldBean("Hello "+id);
    }
}

package com.gaowtam.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String sayHello2()
    {
        return "I am Gaowm!";
    }
    @GetMapping("/output2")
    public String output22()
    {
        return "I Am Output";
    }

}

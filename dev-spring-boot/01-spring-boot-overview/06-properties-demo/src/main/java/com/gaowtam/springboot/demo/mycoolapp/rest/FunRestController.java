package com.gaowtam.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject prpperties for: couch.name and team.name [value set in application.properties]

    @Value("${coach.name}")
    private String couchName;

    @Value("${team.name}")
    private String teamName;

    @Value("${ball}")
    private String footBall;

    //expose a new endpoint for "workout"

    @GetMapping("/teaminfo")
    public String getTeamInfo()
    {
        return "Coach: "+couchName+", Team name: "+teamName+" ball="+footBall;
    }


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

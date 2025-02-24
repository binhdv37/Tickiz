package com.bdv.tickiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")
public class Test {

    @Autowired
    private Environment environment;

    @GetMapping("/env")
    public String getEnv(@RequestParam String env) {
        return environment.getProperty(env);
    }

}

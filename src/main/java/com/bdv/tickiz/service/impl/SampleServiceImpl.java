package com.bdv.tickiz.service.impl;

import com.bdv.tickiz.service.SampleService;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}

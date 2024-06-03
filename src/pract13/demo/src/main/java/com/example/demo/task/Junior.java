package com.example.demo.task;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Junior is coding...");
    }
}

package com.example.demo.task;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Middle is coding...");
    }
}

package com.example.demo.task;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {

    @Override
    public void doCoding() {
        System.out.println("Senior is coding...");
    }
}

package com.example.demo.ex;

import org.springframework.stereotype.Component;

@Component
public class Pantaloons implements Trousers {

    @Override
    public String getName() {
        return "Pantaloons....";
    }
}

package com.example.demo.ex;

import org.springframework.stereotype.Component;

@Component
public class Kostya {
    private final Trousers trousers;
    public Kostya(Trousers trousers) {
        this.trousers = trousers;
    }
    public void walk() {
        System.out.println("I'm wearing " +
                trousers.getName());
    }
}

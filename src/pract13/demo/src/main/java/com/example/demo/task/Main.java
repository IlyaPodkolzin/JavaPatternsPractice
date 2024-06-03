package com.example.demo.task;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = context.getBean(Junior.class);
        Middle middle = context.getBean(Middle.class);
        Senior senior = context.getBean(Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}

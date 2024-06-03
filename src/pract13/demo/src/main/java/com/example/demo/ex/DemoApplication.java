package com.example.demo.ex;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new
				AnnotationConfigApplicationContext(BeanConfig.class);
		Kostya kostya = context.getBean(Kostya.class);
		kostya.walk();
	}

}

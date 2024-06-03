package pract13.src.main.java.com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(lastName);
        System.out.println(group);
    }
}

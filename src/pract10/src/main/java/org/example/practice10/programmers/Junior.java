package pract10.src.main.java.org.example.practice10.programmers;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is coding...");
    }
}

package pract10.src.main.java.org.example.practice10.programmers;


import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding...");
    }
}

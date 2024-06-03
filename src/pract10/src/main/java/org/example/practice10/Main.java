package pract10.src.main.java.org.example.practice10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pract10.src.main.java.org.example.practice10.programmers.Junior;
import pract10.src.main.java.org.example.practice10.programmers.Middle;
import pract10.src.main.java.org.example.practice10.programmers.Senior;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = context.getBean(Junior.class);
        Middle middle = context.getBean(Middle.class);
        Senior senior = context.getBean(Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}

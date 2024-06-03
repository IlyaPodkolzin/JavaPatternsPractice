package pract12.src.main.java.org.example.practice12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice12Application {

    public static void main(String[] args) {

        if (args.length == 2) {
            FileWork.inputFileName = args[0];
            FileWork.outputFileName = args[1];
        }

        SpringApplication.run(Practice12Application.class, args);
    }
}

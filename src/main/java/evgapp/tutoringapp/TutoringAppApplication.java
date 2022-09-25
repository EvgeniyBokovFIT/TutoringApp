package evgapp.tutoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class TutoringAppApplication {

    public static void main(String[] args) {
        final String PATH = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "uploads" + File.separator;

        File directory = new File(PATH);
        if (!directory.exists()){
            directory.mkdirs();
        }
        SpringApplication.run(TutoringAppApplication.class, args);
    }

}

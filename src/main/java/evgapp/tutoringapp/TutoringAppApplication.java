package evgapp.tutoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

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

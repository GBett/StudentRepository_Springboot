package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            // Creating instances of Student with some data
            Student gilbert = new Student(
                    "Gilbert",
                    "gilbertkalo.kalo@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));

            Student bett = new Student(
                    "Bett",
                    "bett.kalo@gmail.com",
                    LocalDate.of(1995, Month.FEBRUARY, 10));

            repository.saveAll(List.of(gilbert, bett));
        };
    }
}

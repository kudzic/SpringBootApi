package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student kudzai=new Student("Kudzai","chidzodzok@gmail.com", LocalDate.of(2002, Month.SEPTEMBER,19));
            Student tayana=new Student("Tayana","tayana@gmail.com",LocalDate.of(2018,Month.DECEMBER,10));
            repository.saveAll(
                    List.of(kudzai,tayana)
            );
        };

    }
}

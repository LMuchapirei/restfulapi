package com.learnspring.restfulapi.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            var myLit=List.of(

                    new Student(
                            1L,
                            "Rutendo",
                            LocalDate.of(2000,12,3),
                            "someone@mail.com"
                    ),
                    new Student(
                            2L,
                            "Tadiwa",
                            LocalDate.of(2000,12,3),
                            "someone1@mail.com"
                    ),
                    new Student(
                            3L,
                            "Nick",
                            LocalDate.of(2000,12,3),
                            "someone2@mail.com"
                    )
            );
            repository.saveAll(myLit);
        };
    }
}

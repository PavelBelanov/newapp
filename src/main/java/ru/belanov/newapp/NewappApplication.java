package ru.belanov.newapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class NewappApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewappApplication.class, args);
    }

}

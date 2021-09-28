package com.example.springbootcouchdatabasewithfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication

public class SpringBootCouchdatabaseWithFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCouchdatabaseWithFileApplication.class, args);
    }

}

package com.european.testproject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String... args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
}

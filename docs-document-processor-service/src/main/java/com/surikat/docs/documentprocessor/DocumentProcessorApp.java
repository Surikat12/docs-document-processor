package com.surikat.docs.documentprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"com.surikat"})
public class DocumentProcessorApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DocumentProcessorApp.class);
        app.run(args);
    }
}

package com.surikat.docs.documentprocessor.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"com.surikat"})
@OpenAPIDefinition(info = @Info(title = "${info.app.name}", description = "${info.app.description}", version = "${info.app.version}"))
public class DocumentProcessorApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DocumentProcessorApp.class);
        app.run(args);
    }
}

package com.demo.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@Configuration
public class FileConfiguration {

    @Value("${input.file.path}")
    private String inputFilePath;

    @Value("${output.file.path}")
    private String outputFilePath;

    @Bean
    public Resource inputFileResource() {
        return new ClassPathResource(inputFilePath);
    }

    @Bean
    public File outputFile() {
        return new File(outputFilePath);
    }
}


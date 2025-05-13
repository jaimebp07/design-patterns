package com.example.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.adapter.model.Person;
import com.example.adapter.service.FileReaderService;

@SpringBootApplication
public class AdapterApplication {
	private static final String path =
                    "adapter" + File.separator +
                    "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "files" + File.separator;
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(AdapterApplication.class, args);
	}

    @Bean
	//CommandLineRunner run(@Qualifier("csv") InputFile inputFile) {
    CommandLineRunner run(FileReaderService fileReaderService) {
		return args -> {
			//String filename = path + "persons.csv";
			String filename = path + "persons.xlsx";
			List<Person> people = fileReaderService.read(filename);
            people.forEach(System.out::println);
		};
	}

    

}

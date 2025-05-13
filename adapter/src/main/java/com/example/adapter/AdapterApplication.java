package com.example.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.adapter.adapter.InputFile;
import com.example.adapter.model.Person;

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
    CommandLineRunner run(@Qualifier("excel") InputFile inputFile) {
		return args -> {
			//InputStream inputStream = new FileInputStream(path + "persons.csv");
			InputStream inputStream = new FileInputStream(path + "persons.xlsx");
			List<Person> personList = inputFile.readFile(inputStream);
			System.out.println(personList);
		};
	}

    

}

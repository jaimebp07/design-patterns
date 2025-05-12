package com.example.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.adapter.adapter.CsvFileAdapter;
import com.example.adapter.adapter.ExcelFileAdapter;
import com.example.adapter.adapter.FileAdapter;
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
		//SpringApplication.run(AdapterApplication.class, args);
		// Read Excel
        /*InputFile excelFileAdapter = new ExcelFileAdapter();
        FileAdapter fileAdapter = new FileAdapter(excelFileAdapter);
        System.out.println(path);
        InputStream inputStream = new FileInputStream(path + "persons.xlsx");
        */
        InputFile csvFileAdapter = new CsvFileAdapter();
        FileAdapter fileAdapter = new FileAdapter(csvFileAdapter);
        InputStream inputStream = new FileInputStream(path + "persons.csv");
        

		List<Person> personList = fileAdapter.readFile(inputStream);
        System.out.println(personList);
	}

}

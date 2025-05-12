package com.example.adapter.adapter;

import java.io.InputStream;
import java.util.List;

import com.example.adapter.model.Person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileAdapter {

    private InputFile inputFile;

    public List<Person> readFile(InputStream inputStream){
        return this.inputFile.readFile(inputStream);
    }
}

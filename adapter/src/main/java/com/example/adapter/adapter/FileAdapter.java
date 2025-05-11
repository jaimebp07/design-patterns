package com.example.adapter.adapter;

import java.io.InputStream;
import java.util.List;

import com.example.adapter.model.Person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileAdapter {

    private InputFile inputFle;

    public List<Person> readFile(InputStream inputStream){
        return this.inputFle.readFile(inputStream);
    }
}

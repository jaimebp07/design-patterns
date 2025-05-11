package com.example.adapter.adapter;

import java.io.InputStream;
import java.util.List;

import com.example.adapter.model.Person;

public interface InputFile {
    List<Person> readFile(InputStream inputStream);
}

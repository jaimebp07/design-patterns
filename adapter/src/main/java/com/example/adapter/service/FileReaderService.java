package com.example.adapter.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.adapter.adapter.InputFile;
import com.example.adapter.model.Person;

@Service
public class FileReaderService {
    private final InputFile inputFile;

    public FileReaderService(@Qualifier("excel") InputFile inputFile) {
        this.inputFile = inputFile;
    }

    public List<Person> read(String filename) {
        try (InputStream inputStream = getFileInputStream(filename)) {
            return inputFile.readFile(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filename, e);
        }
    }

    protected InputStream getFileInputStream(String filename) throws IOException {
        return new FileInputStream(filename);
    }

}


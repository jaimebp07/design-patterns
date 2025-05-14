package com.example.adapter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.adapter.adapter.InputFile;
import com.example.adapter.model.Person;

public class FileReaderServiceTest {

    private InputFile inputFile;
    private FileReaderService fileReaderService;

    @BeforeEach
    void setUp() {
        inputFile = mock(InputFile.class);
        fileReaderService = new FileReaderService(inputFile);
    }

    @Test
    public void shouldReturnListOfPersons_WhenFileIsValid() throws IOException {
        String filePath = "fake/path/file.xlsx";
        ByteArrayInputStream fakeStream = new ByteArrayInputStream(new byte[0]); // simulamos contenido vacío

        // Creamos una versión "espiada" del servicio para interceptar su método protegido
        FileReaderService spyService = Mockito.spy(fileReaderService);

        // Lista simulada que esperamos que retorne
        List<Person> expectedList = List.of(
            new Person("John", "Doe", 30),
            new Person("Jane", "Smith", 25)
        );

        // Simulamos que cuando se llama al adapter, devuelve esa lista
        doReturn(expectedList).when(inputFile).readFile(any());

        // Simulamos que cuando se llame getFileInputStream, devuelva el stream falso
        doReturn(fakeStream).when(spyService).getFileInputStream(filePath);

        // Ejecutamos el método real
        List<Person> result = spyService.read(filePath);

        // Verificamos que devuelve la lista correcta
        assertEquals(expectedList, result);

        // Verificamos que se llamó al método del adapter
        verify(inputFile, times(1)).readFile(any());
    }
}

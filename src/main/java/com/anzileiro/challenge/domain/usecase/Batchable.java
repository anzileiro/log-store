package com.anzileiro.challenge.domain.usecase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

import com.anzileiro.challenge.application.container.Factory;
import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

import org.springframework.web.multipart.MultipartFile;

public class Batchable {

    private LogRepository repository;

    public Batchable(LogRepository repository, Factory factory) {
        this.repository = repository;
        // this.factory = factory;
    }

    private void verify(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("The file provided is empty");
        }
    }

    private BufferedReader setReader(MultipartFile file) throws IOException {
        return new BufferedReader(new InputStreamReader(file.getInputStream()));
    }

    private String[] setSplited(String line) {
        String actual = line.replaceAll("[^/ . : a-zA-Z0-9-|]", "");
        String[] splited = actual.split("\\|");
        return splited;
    }

    public String execute(MultipartFile file) {

        try {

            this.verify(file);

            BufferedReader reader = this.setReader(file);

            ArrayList<Log> logs = new ArrayList<Log>();

            reader.lines().forEach(line -> {

                String[] splited = this.setSplited(line);

                logs.add(new Log(UUID.randomUUID(), splited[0], splited[1], splited[2], Integer.parseInt(splited[3]),
                        splited[4]));

            });

            int size = logs.size();

            System.out.println(String.format("List size: %s", size));

            System.out.println("List formated.");

            this.repository.insertMany(logs);

            System.out.println("List inserted.");

            return String.valueOf(size);

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

package com.anzileiro.challenge.domain.usecase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

import org.springframework.web.multipart.MultipartFile;

public class Batchable {

    private LogRepository repository;
    private ArrayList<Log> logs;
    private int quantity;

    public Batchable(LogRepository repository) {
        this.repository = repository;
        this.logs = new ArrayList<Log>();
        this.quantity = 0;
    }

    private void validate(MultipartFile file) {
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

    private void addLogs(BufferedReader reader) {
        reader.lines().forEach(line -> {

            String[] splited = this.setSplited(line);

            Log log = new Log(
                UUID.randomUUID(), 
                splited[0], 
                splited[1], 
                splited[2], 
                Integer.parseInt(splited[3]),
                splited[4]
            );

            logs.add(log);

        });

        this.setQuantity(logs.size());
    }

    private ArrayList<Log> getLogs() {
        return this.logs;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int getQuantity() {
        return this.quantity;
    }

    public String execute(MultipartFile file) {

        try {

            this.validate(file);

            this.addLogs(this.setReader(file));

            System.out.println(String.format("List size: %s", this.getQuantity()));

            System.out.println("List formated.");

            this.repository.insertMany(this.getLogs());

            System.out.println("List inserted.");

            return String.valueOf(this.getQuantity());

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

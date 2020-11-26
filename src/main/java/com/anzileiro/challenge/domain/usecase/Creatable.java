package com.anzileiro.challenge.domain.usecase;

import java.net.URI;
import java.util.UUID;

import com.anzileiro.challenge.application.container.Factory;
import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

public class Creatable {

    private LogRepository repository;

    public Creatable(LogRepository repository) {
        this.repository = repository;
    }

    public URI execute(Log log) {

        this.repository.insertOne(log);

        String resource = String.format("http://localhost:8080/v1/logs/%s", log.getId());

        return URI.create(resource);
    }

}

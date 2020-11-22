package com.anzileiro.challenge.domain.usecase;

import java.util.UUID;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

public class Updatable {

    private LogRepository repository;

    public Updatable(LogRepository repository) {
        this.repository = repository;
    }

    public Log execute(UUID id, Log log) {
        return this.repository.findOneById(id);
    }

}

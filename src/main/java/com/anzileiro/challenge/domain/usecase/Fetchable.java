package com.anzileiro.challenge.domain.usecase;

import java.util.UUID;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

public class Fetchable {

    private LogRepository repository;

    public Fetchable(LogRepository repository) {
        this.repository = repository;
    }

    public Log execute(UUID id) {
        return this.repository.findOneById(id);
    }

}

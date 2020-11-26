package com.anzileiro.challenge.domain.usecase;

import java.util.ArrayList;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

public class Searchable {

    private LogRepository repository;

    public Searchable(LogRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Log> execute(String date) {
        return this.repository.findManyByDate(date);
    }

}

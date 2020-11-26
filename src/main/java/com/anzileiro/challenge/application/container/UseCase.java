package com.anzileiro.challenge.application.container;

import com.anzileiro.challenge.domain.usecase.Batchable;
import com.anzileiro.challenge.domain.usecase.Creatable;
import com.anzileiro.challenge.domain.usecase.Fetchable;
import com.anzileiro.challenge.domain.usecase.Searchable;
import com.anzileiro.challenge.infrastructure.repository.LogRepositoryImplementation;

public class UseCase {

    private LogRepositoryImplementation repository;
    private Factory factory;

    public UseCase(LogRepositoryImplementation repository) {
        this.repository = repository;
    }

    public Fetchable fetchable() {
        return new Fetchable(this.repository);
    }

    public Creatable createble() {
        return new Creatable(this.repository);
    }

    public Batchable batchable() {
        return new Batchable(this.repository);
    }

    public Searchable searchable() {
        return new Searchable(this.repository);
    }

}

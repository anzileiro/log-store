package com.anzileiro.challenge.application.container;

import com.anzileiro.challenge.domain.usecase.Batchable;
import com.anzileiro.challenge.domain.usecase.Creatable;
import com.anzileiro.challenge.domain.usecase.Fetchable;
import com.anzileiro.challenge.infrastructure.repository.LogRepositoryImplementation;

public class UseCase {

    private Factory factory;
    private LogRepositoryImplementation repository;

    public UseCase(LogRepositoryImplementation repository) {
        this.repository = repository;
        this.factory = new Factory();
    }

    public Fetchable fetchable() {
        return new Fetchable(this.repository);
    }

    public Creatable createble() {
        return new Creatable(this.repository, this.factory);
    }

    public Batchable batchable() {
        return new Batchable(this.repository, this.factory);
    }

}

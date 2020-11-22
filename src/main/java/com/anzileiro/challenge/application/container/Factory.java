package com.anzileiro.challenge.application.container;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.infrastructure.repository.LogEntity;

public class Factory {

    public Log createFromEntity(LogEntity entity) {
        return new Log(entity.getId(), entity.getDate(), entity.getIp(), entity.getRequest(), entity.getStatus(),
                entity.getAgent());
    }

    public LogEntity createFromDomain(Log domain) {
        return new LogEntity(domain.getId(), domain.getDate(), domain.getIp(), domain.getRequest(), domain.getStatus(),
                domain.getAgent());
    }

}

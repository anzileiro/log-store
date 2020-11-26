package com.anzileiro.challenge.application.container;

import java.util.ArrayList;

import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.infrastructure.repository.LogEntity;

public class Factory {

    public Log toDomain(LogEntity entity) {
        return new Log(entity.getId(), entity.getDate(), entity.getIp(), entity.getRequest(), entity.getStatus(),
                entity.getAgent());
    }

    public LogEntity toEntity(Log domain) {
        return new LogEntity(domain.getId(), domain.getDate(), domain.getIp(), domain.getRequest(), domain.getStatus(),
                domain.getAgent());
    }

    public String toSQL(ArrayList<Log> logs) {
        StringBuilder builder = new StringBuilder();

        builder.append("INSERT INTO tbl_log (id, agent, date, ip, request, status) VALUES");

        logs.forEach((log) -> {
            builder.append(String.format(" ('%s', '%s', '%s', '%s', '%s', %s),", log.getId(), log.getAgent(),
                    log.getDate(), log.getIp(), log.getRequest(), log.getStatus()));
        });

        return builder.substring(0, builder.length() - 1) + ";";
    }

}

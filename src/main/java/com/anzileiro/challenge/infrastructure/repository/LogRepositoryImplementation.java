package com.anzileiro.challenge.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.anzileiro.challenge.application.container.Factory;
import com.anzileiro.challenge.domain.Log;
import com.anzileiro.challenge.domain.LogRepository;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LogRepositoryImplementation implements LogRepository {

    private Factory factory;

    @PersistenceContext
    EntityManager entityManager;

    public LogRepositoryImplementation() {
        this.factory = new Factory();
    }

    @Override
    public void insertOne(Log log) {
        entityManager.persist(this.factory.createFromDomain(log));
    }

    @Override
    public void updateOne(UUID id, Log log) {

    }

    @Override
    public void insertMany(ArrayList<Log> logs) {

        StringBuilder builder = new StringBuilder();

        builder.append("INSERT INTO tbl_log (id, agent, date, ip, request, status) VALUES");

        logs.forEach((log) -> {
            builder.append(String.format(" ('%s', '%s', '%s', '%s', '%s', %s),", log.getId(), log.getAgent(),
                    log.getDate(), log.getIp(), log.getRequest(), log.getStatus()));
        });

        String result = builder.substring(0, builder.length() - 1) + ";";
        Query query = entityManager.createNativeQuery(result);
        query.executeUpdate();
    }

    @Override
    public Log findOneById(UUID id) {
        return this.factory.createFromEntity(entityManager.find(LogEntity.class, id));
    }

    @Override
    public List<Log> findManyByDate(String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Log> findManyByStatus(String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Log> findManyByRequest(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Log> findManyByAgent(String agent) {
        // TODO Auto-generated method stub
        return null;
    }

}

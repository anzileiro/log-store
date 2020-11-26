package com.anzileiro.challenge.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        entityManager.persist(this.factory.toEntity(log));
    }

    @Override
    public void updateOne(UUID id, Log log) {

    }

    @Override
    public void insertMany(ArrayList<Log> logs) {
        Query query = entityManager.createNativeQuery(this.factory.toSQL(logs));
        query.executeUpdate();
    }

    @Override
    public Log findOneById(UUID id) {
        return this.factory.toDomain(entityManager.find(LogEntity.class, id));
    }

    @Override
    public ArrayList<Log> findManyByDate(String date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LogEntity> query = cb.createQuery(LogEntity.class);
        Root<LogEntity> entity = query.from(LogEntity.class);

        Path<String> key = entity.get("date");

        Predicate predicate = cb.equal(key, date);

        query.select(entity).where(predicate);

        ArrayList<Log> logs = new ArrayList<Log>();

        entityManager.createQuery(query).getResultList().forEach((item) -> {
            logs.add(new Log(item.getId(), item.getDate(), item.getIp(), item.getRequest(), item.getStatus(),
                    item.getAgent()));
        });

        return logs;
    }

    @Override
    public ArrayList<Log> findManyByStatus(String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Log> findManyByRequest(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Log> findManyByAgent(String agent) {
        // TODO Auto-generated method stub
        return null;
    }

}

package com.anzileiro.challenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface LogRepository {
    
    void insertOne(Log log);
    void insertMany(ArrayList<Log> logs);
    void updateOne(UUID id, Log log);

    Log findOneById(UUID id);
    List<Log> findManyByDate(String date);
    List<Log> findManyByStatus(String status);
    List<Log> findManyByRequest(String request);
    List<Log> findManyByAgent(String agent);
}

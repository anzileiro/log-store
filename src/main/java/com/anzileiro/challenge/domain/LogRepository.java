package com.anzileiro.challenge.domain;

import java.util.ArrayList;
import java.util.UUID;

public interface LogRepository {
    
    void insertOne(Log log);
    void insertMany(ArrayList<Log> logs);
    void updateOne(UUID id, Log log);

    Log findOneById(UUID id);
    ArrayList<Log> findManyByDate(String date);
    ArrayList<Log> findManyByStatus(String status);
    ArrayList<Log> findManyByRequest(String request);
    ArrayList<Log> findManyByAgent(String agent);
}

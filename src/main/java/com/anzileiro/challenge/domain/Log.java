package com.anzileiro.challenge.domain;

import java.util.UUID;

public class Log {

    private UUID id;
    private String date;
    private String ip;
    private String request;
    private Integer status;
    private String agent;

    protected Log() {
    }

    public Log(String date, String ip, String request, Integer status, String agent) {
        this.date = date;
        this.ip = ip;
        this.request = request;
        this.status = status;
        this.agent = agent;
    }

    public Log(UUID id, String date, String ip, String request, Integer status, String agent) {
        this.id = id;
        this.date = date;
        this.ip = ip;
        this.request = request;
        this.status = status;
        this.agent = agent;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRequest() {
        return this.request;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgent() {
        return this.agent;
    }

}

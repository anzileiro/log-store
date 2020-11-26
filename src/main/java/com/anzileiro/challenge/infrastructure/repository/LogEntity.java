package com.anzileiro.challenge.infrastructure.repository;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "tbl_log")
public class LogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "date", updatable = true, nullable = false)
    private String date;

    @Column(name = "ip", updatable = true, nullable = false)
    private String ip;

    @Column(name = "request", updatable = true, nullable = false)
    private String request;

    @Column(name = "status", updatable = true, nullable = false)
    private Integer status;

    @Column(name = "agent", updatable = true, nullable = false)
    private String agent;

    protected LogEntity() {
    }

    public LogEntity(UUID id, String date, String ip, String request, Integer status, String agent) {
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
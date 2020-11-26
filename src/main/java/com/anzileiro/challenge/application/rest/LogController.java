package com.anzileiro.challenge.application.rest;

import java.util.ArrayList;
import java.util.UUID;

import com.anzileiro.challenge.application.container.UseCase;
import com.anzileiro.challenge.domain.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/logs")
public class LogController {

    @Autowired
    private UseCase useCase;

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> insertOne(@RequestBody Log log) {
        return ResponseEntity.created(this.useCase.createble().execute(log)).build();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Log> findOneById(@PathVariable UUID id) {
        return new ResponseEntity<Log>(this.useCase.fetchable().execute(id), HttpStatus.OK);
    }

    @GetMapping(value = "/date/{date}")
    @ResponseBody
    public ResponseEntity<ArrayList<Log>> findAllByDate(@PathVariable String date) {
        return new ResponseEntity<ArrayList<Log>>(this.useCase.searchable().execute(date), HttpStatus.OK);
    }

}
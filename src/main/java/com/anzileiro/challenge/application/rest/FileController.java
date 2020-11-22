package com.anzileiro.challenge.application.rest;

import com.anzileiro.challenge.application.container.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/files")
public class FileController {

    @Autowired
    private UseCase useCase;

    @PostMapping(consumes = { "multipart/form-data" })
    @ResponseBody
    public ResponseEntity<String> insertOne(@RequestParam MultipartFile file) {

        return ResponseEntity.accepted().body(this.useCase.batchable().execute(file));
    }

}
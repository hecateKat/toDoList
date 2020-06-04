package com.kat.todolist.lang.controller;

import com.kat.todolist.lang.dto.LangDTO;
import com.kat.todolist.lang.implementation.LangServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LangController {

    private final Logger logger = LoggerFactory.getLogger(LangController.class);

    private LangServiceImpl langServiceImpl;


    public LangController(LangServiceImpl langServiceImpl) {
        this.langServiceImpl = langServiceImpl;
    }

    @GetMapping("/langs")
    public ResponseEntity<List<LangDTO>> findAll(){
        logger.info("Got request");
        return ResponseEntity.ok(langServiceImpl.findAll());
    }
}
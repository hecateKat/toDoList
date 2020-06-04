package com.kat.todolist.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LangServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangService langService;


    public LangServlet(LangService langService) {
        this.langService = langService;
    }

    @GetMapping("/langs")
    public ResponseEntity<List<LangDTO>> findAll(){
        logger.info("Got request");
        return ResponseEntity.ok(langService.findAll());
    }
}
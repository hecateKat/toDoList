package com.kat.todolist.hello.controller;

import com.kat.todolist.hello.Implementation.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private HelloServiceImpl helloServiceImpl;

    public HelloController(HelloServiceImpl helloServiceImpl) {
        this.helloServiceImpl = helloServiceImpl;
    }

    @GetMapping("/api")
    public String welcome(){
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    public String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Got request");
        return helloServiceImpl.prepareGreeting(name, langId);
    }
}

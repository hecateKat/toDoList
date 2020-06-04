package com.kat.todolist.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HelloServlet {

    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService helloService;

    public HelloServlet(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/api")
    public String welcome(){
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    public String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Got request");
        return helloService.prepareGreeting(name, langId);
    }
}

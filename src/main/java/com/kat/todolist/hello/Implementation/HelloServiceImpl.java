package com.kat.todolist.hello.Implementation;


import com.kat.todolist.hello.service.HelloService;
import com.kat.todolist.lang.entity.Lang;
import com.kat.todolist.lang.repository.LangRepository;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "EN");

    private LangRepository langRepository;

    public HelloServiceImpl(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    @Override
    public String prepareGreeting(String name, Integer lang){
        Integer langId = Optional.ofNullable(lang).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = langRepository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}
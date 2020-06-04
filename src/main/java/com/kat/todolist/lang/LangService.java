package com.kat.todolist.lang;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class LangService {
    private LangRepository langRepository;

    public LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    List<LangDTO> findAll() {
        return langRepository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());

    }
}

package com.kat.todolist.lang.implementation;

import com.kat.todolist.lang.dto.LangDTO;
import com.kat.todolist.lang.repository.LangRepository;
import com.kat.todolist.lang.service.LangService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class LangServiceImpl implements LangService {
    private LangRepository langRepository;

    public LangServiceImpl(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    @Override
    public List<LangDTO> findAll() {
        return langRepository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());

    }
}

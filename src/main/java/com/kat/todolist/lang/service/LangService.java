package com.kat.todolist.lang.service;

import com.kat.todolist.lang.dto.LangDTO;

import java.util.List;

public interface LangService {
    public List<LangDTO> findAll();
}

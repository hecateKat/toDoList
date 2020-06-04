package com.kat.todolist.lang.repository;

import com.kat.todolist.lang.entity.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepository extends JpaRepository<Lang, Integer> {
}
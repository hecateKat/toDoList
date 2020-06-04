package com.kat.todolist.todo.controller;
import com.kat.todolist.todo.entity.Todo;
import com.kat.todolist.todo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(TodoController.class);

    private TodoRepository todoRepository;

    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll(){
        logger.info("Got request");
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Todo> toggleTodo(@PathVariable Integer id) {
        var todo = todoRepository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            todoRepository.save(t);
        });
        ResponseEntity<Todo> todoResponseEntity = todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        return todoResponseEntity;
    }

    @PostMapping
    public ResponseEntity<Todo> saveOneTodo (@RequestBody Todo todo){
        return ResponseEntity.ok(todoRepository.save(todo));
    }

}

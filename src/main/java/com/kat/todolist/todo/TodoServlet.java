package com.kat.todolist.todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoServlet {

    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);

    private TodoRepository todoRepository;

    TodoServlet(TodoRepository todoRepository) {
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

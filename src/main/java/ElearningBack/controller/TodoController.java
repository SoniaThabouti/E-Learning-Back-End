package ElearningBack.controller;
import ElearningBack.model.Course;
import ElearningBack.repository.TodoRepository;
import ElearningBack.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/v1/")
public class TodoController {

    final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {

        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }


    @GetMapping(value="/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        return todoRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id,
                                           @Valid @RequestBody Todo todo) {
        return todoRepository.findById(id)
                .map(todoData -> {
                    todoData.setTitle(todo.getTitle());
                    todoData.setCompleted(todo.getCompleted());
                    Todo updatedTodo = todoRepository.save(todoData);
                    return ResponseEntity.ok().body(updatedTodo);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

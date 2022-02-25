package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private ListService listservice;

    @GetMapping(value = "todos")
    public Iterable<TodoEntity> list(){
        return listservice.list();
    }
    
    @PostMapping("todo")
    public TodoEntity saveTodo(@RequestBody TodoEntity todo){
        return listservice.saveTodo(todo);
    }

    @PutMapping(value = "todo")
    public TodoEntity updateTodo(@RequestBody TodoEntity todo){
        try {
            if(todo.getId() != null){
                return listservice.saveTodo(todo);
            }
            throw new RuntimeException("No existe el id para actualizar");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return todo;
    }

    @DeleteMapping(value = "todo/{id}")
    public void deleteTodoById(@PathVariable("id")Long id){
        listservice.deleteTodo(id);
    }

    @GetMapping(value = "todo/{id}")
    public TodoEntity getTodoId(@PathVariable("id") Long id){
        return listservice.getTodo(id);
    }

}

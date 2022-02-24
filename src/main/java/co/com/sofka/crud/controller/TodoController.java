package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TodoEntities;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoEntities> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public TodoEntities save(@RequestBody TodoEntities todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public TodoEntities update(@RequestBody TodoEntities todo){
        System.out.println("Este es el todo:" + todo.getId());
        try {
            if(todo.getId() != null){
                return service.save(todo);
            }
            throw new RuntimeException("No existe el id para actualizar");
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return todo;
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoEntities get(@PathVariable("id") Long id){
        return service.get(id);
    }

}

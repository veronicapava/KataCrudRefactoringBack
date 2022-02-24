package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TodoEntities;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "todos")
    public Iterable<TodoEntities> list(){
        return service.list();
    }
    
    @PostMapping(value = "todo")
    public TodoEntities save(@RequestBody TodoEntities todo){
        return service.save(todo);
    }

    @PutMapping(value = "todo")
    public TodoEntities update(@RequestBody TodoEntities todo){
        try {
            if(todo.getId() != null){
                return service.save(todo);
            }
            throw new RuntimeException("No existe el id para actualizar");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return todo;
    }

    @DeleteMapping(value = "todo/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "todo/{id}")
    public TodoEntities get(@PathVariable("id") Long id){
        return service.get(id);
    }

}

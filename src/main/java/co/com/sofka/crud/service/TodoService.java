package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.TodoEntities;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<TodoEntities> list(){
        return repository.findAll();
    }

    public TodoEntities save(TodoEntities todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public TodoEntities get(Long id){
         return repository.findById(id).orElseThrow();
    }

}

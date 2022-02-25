package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    //Metodo para obtener todos los todos
    public ArrayList<TodoEntity> getAllToDos(){
        return (ArrayList<TodoEntity>) todoRepository.findAll();
    }

    //Metodo para guardar todos
    public TodoEntity saveToDo(TodoEntity todo){
        if(todo.getName().equals("fallido")){
            throw new RuntimeException("Este nombre no esta permitido");
        }
        if(todo.getList() == null){
            throw new RuntimeException("La lista no puede ser vacia");
        }
        return todoRepository.save(todo);
    }

    //Metodo para obtener todos por id
    public Optional<TodoEntity> getToDoById(Long id){
        return todoRepository.findById(id);
    }

    //Metodo para eliminar todos por id
    public void deleteToDoById(Long id){
       todoRepository.deleteById(id);
    }

}

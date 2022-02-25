package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Objects;
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

    //Metodo para actualizar todos
    public TodoEntity updateTodo(Long id, TodoEntity todo){


        Optional<TodoEntity> currentTodo = todoRepository.findById(id);

        if (currentTodo.isPresent()){
            TodoEntity _currentTodo = currentTodo.get();
            Long currentList = _currentTodo.getList().getId();
            Long newTodoListId = todo.getList().getId();

            if(!Objects.equals(currentList, newTodoListId)){
                throw new RuntimeException("Cambiar la lista está prohibido");
            }
        }

        if(todo.getId() != null){
            return todoRepository.save(todo);
        }

        throw new RuntimeException("No existe el id para actualizar");
    }

}

package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    //Metodo para obtener todos los todos mediante el DTO
    public List<ToDoListDTO> getAllTodosWithList(){
        return todoRepository.findAll().
                stream().
                map(this::convertEntityToDto).
                collect(Collectors.toList());
    }

    private ToDoListDTO convertEntityToDto(TodoEntity todo){
        ToDoListDTO todoDto = new ToDoListDTO();
        todoDto.setIdToDo(todo.getId());
        todoDto.setCompleted(todo.isCompleted());
        todoDto.setNameToDo(todo.getName());
        todoDto.setIdList(todo.getList().getId());
        return todoDto;
    }


    //Metodo para guardar todos
    /*public List<ToDoListDTO> saveToDO(ToDoListDTO tododto){
        return todoRepository.save(tododto);
    }*/



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
    public TodoEntity getToDoById(Long id){
        Optional<TodoEntity> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new RuntimeException("No existe todo");
        }
        /*return todoRepository.findById(id).orElseThrow();*/
    }

    //Metodo para actualizar todos por id
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




    //Metodo para eliminar todos por id
    public String deleteToDoById(Long id){
        Optional<TodoEntity> currentTodoById = todoRepository.findById(id);

        if (currentTodoById.isPresent()){
            TodoEntity _currentTodo = currentTodoById.get();
            todoRepository.delete(_currentTodo);
            return "ToDo Eliminado papu";
        } else {
            throw new RuntimeException("No existe el todo a eliminar");
        }
    }

}

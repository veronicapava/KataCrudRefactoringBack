package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    ModelMapper mapper;

    //Metodo para obtener todos los toDos mediante el DTO
    public List<ToDoListDTO> getAllTodosWithList(){
        return todoRepository.findAll().
                stream().
                map(this::convertEntityToDto).
                collect(Collectors.toList());
    }

    private ToDoListDTO convertEntityToDto(TodoEntity todo){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ToDoListDTO todoDto = new ToDoListDTO();
        todoDto = mapper.map(todo, ToDoListDTO.class);
        return todoDto;
    }


    //Guardar toDos usando DTO
    public ToDoListDTO saveToDo(ToDoListDTO todo){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TodoEntity todoEnt = new TodoEntity();
        todoEnt = mapper.map(todo, TodoEntity.class);
        if(todoEnt.getList() == null){
            throw new RuntimeException("La lista no puede ser vacía cuando se crea un todo");}
        TodoEntity hola = todoRepository.save(todoEnt);
        return mapper.map(hola, ToDoListDTO.class);
    }


    //Metodo para obtener toDos por id
    public TodoEntity getToDoById(Long id){
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new RuntimeException("No existe todo");
        }
    }

    //Metodo para actualizar toDos por id
    public TodoEntity updateTodo(long id, TodoEntity todo){
        Optional<TodoEntity> currentTodo = todoRepository.findById(id);

        if (currentTodo.isPresent()){
            TodoEntity _currentTodo = currentTodo.get();
            long currentList = _currentTodo.getList().getId();
            long newTodoListId = todo.getList().getId();
            if(currentList != newTodoListId){
                throw new RuntimeException("Cambiar la lista está prohibido");
            }
        }
        if(todo.getId() != null){
            return todoRepository.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }


    //Metodo para eliminar toDos por id
    public String deleteToDoById(Long id){
        Optional<TodoEntity> currentTodoById = todoRepository.findById(id);
        if (currentTodoById.isPresent()){
            TodoEntity _currentTodo = currentTodoById.get();
            todoRepository.delete(_currentTodo);
            return "ToDo eliminado";
        } else {
            throw new RuntimeException("No existe el todo a eliminar");
        }
    }

}

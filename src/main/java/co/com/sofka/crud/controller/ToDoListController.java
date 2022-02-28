package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ToDoListController {

    @Autowired
    private TodoService todoService;

    //Obtener los toDos con DTO
    @GetMapping(value = "/todos")
    public List<ToDoListDTO> getAllTodoS(){
        return todoService.getAllTodosWithList();
    }

    //Guardar toDos usando DTO
    @PostMapping("/todo")
    public ResponseEntity<ToDoListDTO> saveToDo(@RequestBody ToDoListDTO todo ){
        try {
            ToDoListDTO newToDo = todoService.saveToDo(todo);
            return  new ResponseEntity<>(newToDo, HttpStatus.CREATED);
        }catch (Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    //Actualizar toDos por id
    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable("id") long id, @RequestBody TodoEntity todo){
        try {
            TodoEntity newToDo= todoService.updateTodo(id, todo);
            return new ResponseEntity<>(newToDo, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar la lista");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Obtener toDos por id
    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoEntity> getTodobyId(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>(todoService.getToDoById(id),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Metodo para borrar toDos por id
    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(todoService.deleteToDoById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}

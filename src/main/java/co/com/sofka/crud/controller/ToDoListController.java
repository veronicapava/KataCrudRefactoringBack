package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.TodoRepository;
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

    @Autowired
    private TodoRepository todoRepository;


    //Obtenemos todos los todos
    @GetMapping(value = "/todos")
    public ResponseEntity<List<TodoEntity>> getAllToDos(){
      List<TodoEntity> allToDos = todoService.getAllToDos();
      if(allToDos.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(allToDos, HttpStatus.OK);
    }

    //Guardar todos
    @PostMapping("/todo")
    public ResponseEntity<TodoEntity> saveTodo(@RequestBody TodoEntity todo){
        System.out.println(todo.toString());
        try{
            TodoEntity newToDo= todoService.saveToDo(todo);
            return new ResponseEntity<>(newToDo, HttpStatus.CREATED);
        } catch(Exception err){
            System.out.println(err.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    //Actualizar
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


    //Metodo delete
    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id){
        try {
            todoRepository.findById(id);
            if(todoRepository.findById(id).isPresent()){
                todoRepository.deleteById(id);
                return new ResponseEntity<>("ToDo eliminado", HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return null;
    }



    /*@DeleteMapping(value = "todo/delete/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable("id") long id){
      *//* return new ResponseEntity<>(todoService.deleteToDoById(id), HttpStatus.OK) ;*//*
        System.out.println(id);
        try {
            todoRepository.deleteById(id);
            return new ResponseEntity<>("Project delete",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }*/

}

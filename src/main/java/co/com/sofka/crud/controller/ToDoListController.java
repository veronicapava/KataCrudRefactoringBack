package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ToDoListController {

    @Autowired
    private TodoService todoService;

    //Obtener los todos con dto
    @GetMapping(value = "/todos")
    public List<ToDoListDTO> getAllTodoS(){
        return todoService.getAllTodosWithList();
    }

   /* @GetMapping(value = "/todosolito")
    public List<TodoEntity> getAllTodo(){
        return todoService.getAllToDos();
    }*/

    /*//Obtenemos todos los todos
    @GetMapping(value = "/todos")
    public ResponseEntity<List<TodoEntity>> getAllToDos(){
      List<TodoEntity> allToDos = todoService.getAllToDos();
      if(allToDos.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(allToDos, HttpStatus.OK);
    }*/

    //Guardar todos
   /* @PostMapping("/todo")
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
*/

    //Actualizar todos por id
   /* @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable("id") long id, @RequestBody TodoEntity todo){
        try {
            TodoEntity newToDo= todoService.updateTodo(id, todo);
            return new ResponseEntity<>(newToDo, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar la lista");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }*/

    /*@GetMapping("/todo/{id}")
    public void deleteTodo(@PathVariable("id") long id){
        todoService.deleteTodo(id);

    }*/


    /*//Metodo delete
    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id){

        try {
            todoService.deleteToDoById(id);
            return new ResponseEntity<>("ToDo eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }*/

    /*@DeleteMapping(value = "api/{id}")
    public void deleteById(@PathVariable("id")Long id){
        todoService.deleteToDoById(id);
    }*/



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

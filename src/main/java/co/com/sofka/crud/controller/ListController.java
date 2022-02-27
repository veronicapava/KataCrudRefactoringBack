package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.ListRepository;
import co.com.sofka.crud.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ListController {

    @Autowired
    ListService listservice;


    //Obtenemos todas las listas
    @GetMapping(value = "/list")
    public ResponseEntity<List<ListEntity>> getAllList() {
        List<ListEntity> allList = listservice.getAllList();
        if (allList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    //Buscar lista by Id
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<ListEntity> getListById(@PathVariable("id") Long id){
        Optional<ListEntity> listData = listservice.getListById(id);
        if(listData.isPresent()){
            return new ResponseEntity<>(listData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Guardar lista
    @PostMapping(value = "/list")
    public ResponseEntity<ListEntity> saveList(@RequestBody ListEntity list){
        try{
            ListEntity newList= listservice.saveList(list);
            return new ResponseEntity<>(newList, HttpStatus.CREATED);
        } catch(Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Actualizar lista por id
    @PutMapping(value = "/list/{id}")
    public ResponseEntity<ListEntity> updateList(@PathVariable("id") long id, @RequestBody ListEntity list){
        try {
            ListEntity newList= listservice.updateList(id, list);
            return new ResponseEntity<>(newList, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar la lista");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "list/{id}")
    public ResponseEntity<String> deleteListById(@PathVariable("id")Long id){
        try {
            listservice.deleteListById(id);
            return new ResponseEntity<>("Lista eliminada", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

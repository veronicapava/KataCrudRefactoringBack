package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.ListEntity;
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

    @Autowired
    ListRepository listRepository;

    //Obtenemos todas las listas
    @GetMapping(value = "/list")
    public ResponseEntity<List<ListEntity>> getAllList() {
        List<ListEntity> allList = listservice.getAllList();
        if (allList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allList, HttpStatus.OK);
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

    //Buscar lista by Id
    @GetMapping(value = "list/{id}")
    public ResponseEntity<ListEntity> getListById(@PathVariable("id") Long id){
        Optional<ListEntity> listData = listRepository.findById(id);
        if(listData.isPresent()){
            return new ResponseEntity<>(listData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







/*



    @PutMapping(value = "list")
    public ListEntity updateList(@RequestBody ListEntity list){
        try {
            if(list.getId() != null){
                return listservice.saveList(list);
            }
            throw new RuntimeException("No existe el id para actualizar");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @DeleteMapping(value = "list/{id}")
    public void deleteListById(@PathVariable("id")Long id){
        listservice.deleteList(id);
    }



*/

}

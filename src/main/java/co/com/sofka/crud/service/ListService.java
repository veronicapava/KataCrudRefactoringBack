package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.ListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ListService {

    @Autowired
    ListRepository listRepository;

    //Metodo para obtener todas las listas
    public ArrayList<ListEntity> getAllList(){
        return (ArrayList<ListEntity>) listRepository.findAll();
    }

    /*ToDoListDTO newDtoToDo = new ToDoListDTO();
        BeanUtils.copyProperties(newDtoToDo);
        return ResponseEntity.ok(newDtoToDo);*/


    //Metodo para guardar listas
    public ListEntity saveList(ListEntity list){
        return listRepository.save(list);
    }

    //Metodo para obtener listas por id
    public Optional<ListEntity> getListById(Long id){
        return listRepository.findById(id);
    }

    //Metodo para eliminar listas por id
    public void deleteListById(Long id){
        Optional<ListEntity> currentList = listRepository.findById(id);

        if(currentList.isPresent()){
            ListEntity _currentlist = currentList.get();
            System.out.println("lista encontrada");
            listRepository.delete(_currentlist);
        }else {
            throw new RuntimeException("No existe lista para borrar");
        }
    }

   //Metodo para actualizar lista por id
    public ListEntity updateList(Long id, ListEntity list){
        Optional<ListEntity> currentList = listRepository.findById(id);

        if(currentList.isPresent()){
            ListEntity _list = currentList.get();
            _list.setName(list.getName());
            return listRepository.save(_list);
        }
        throw new RuntimeException("No existe lista para actualizar");
    }
}

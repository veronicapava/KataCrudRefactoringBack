package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        listRepository.deleteById(id);
    }
}

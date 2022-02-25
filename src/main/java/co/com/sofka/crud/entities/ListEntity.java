package co.com.sofka.crud.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    //Una lista a muchos toDos
    //OrphanRemoval: remueve todos los toDos cuando no haya una lista padre
    //Fetch: cuando se actualiza la lista, se actualizan todos los todos
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.EAGER)
    private Set<TodoEntity> toDos; //nos indica que no se pueden repetir toDos

    //Constructores

    public ListEntity() {
    }

    public ListEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    //Getters y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public Set<TodoEntity> getToDos() {
        return toDos;
    }

    public void setToDos(Set<TodoEntity> toDos) {
        this.toDos = toDos;
    }*/

    //ToString

    @Override
    public String toString() {
        return "ListEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

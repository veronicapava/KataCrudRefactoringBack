package co.com.sofka.crud.entities;

import co.com.sofka.crud.dto.ListDTO;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ListEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_list;

    @Column(name = "list", nullable = false, unique = true)
    private String name;


    //Constructores
    public void ListEntities(){

    }

    public void  ListEntities(String name) {
        this.name = name;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ListGroupTodos",
            joinColumns = {@JoinColumn(name = "id_list")},
            inverseJoinColumns = {@JoinColumn(name = "groupListId" )}
    )
    private List<TodoEntities> listtodo = new ArrayList<TodoEntities>();


    //Getters y setter

    public Long getId() {
        return id_list;
    }

    public void setId(Long id_list) {
        this.id_list = id_list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoEntities> getListtodo() {
        return listtodo;
    }

    public void setListtodo(List<TodoEntities> listtodo) {
        this.listtodo = listtodo;
    }

    //ToString

    @Override
    public String toString() {
        return "ListModel{" +
                "id=" + id_list +
                ", name='" + name + '\'' +
                '}';
    }

    //hashEquals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListDTO)) return false;
        ListDTO listModel = (ListDTO) o;
        return getId().equals(listModel.getId()) && getName().equals(listModel.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
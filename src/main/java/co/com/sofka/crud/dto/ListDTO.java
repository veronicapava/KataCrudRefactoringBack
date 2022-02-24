package co.com.sofka.crud.dto;

import java.util.Objects;

public class ListDTO {

    private Long id_list;
    private String name;

    //Constructores
    public ListDTO(){
    }

    public ListDTO(String name) {
        this.name = name;
    }



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


package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private boolean completed;

    //Muchos toDos para una lista (Entities asociadas)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id") // Enlaza la entidad toDos a una lista usando su id
    private ListEntity list;


    //Constructores

    public TodoEntity() {
    }

    public TodoEntity(Long id, String name, boolean completed, ListEntity list) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.list = list;
    }

    //Getters y setters

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ListEntity getList() {
        return list;
    }

    public void setList(ListEntity list) {
        this.list = list;
    }

    //ToString

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", list=" + list +
                '}';
    }
}


package co.com.sofka.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoEntities {
    @Id
    @GeneratedValue
    private Long id_todo;
    private String name;
    private boolean completed;
    private String groupListId;

    public TodoEntities(){

    }

    public TodoEntities(String name, boolean completed, String groupListId) {
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }

    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id_todo;
    }

    public void setId(Long id) {
        this.id_todo = id;
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
}

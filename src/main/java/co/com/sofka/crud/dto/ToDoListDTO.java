package co.com.sofka.crud.dto;

public class ToDoListDTO {

    private Long idToDo;
    private String nameToDo;
    private boolean completed;
    private Long idList;

    public Long getIdToDo() {
        return idToDo;
    }

    public void setIdToDo(Long idToDo) {
        this.idToDo = idToDo;
    }

    public String getNameToDo() {
        return nameToDo;
    }

    public void setNameToDo(String nameToDo) {
        this.nameToDo = nameToDo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getIdList() {
        return idList;
    }

    public void setIdList(Long idList) {
        this.idList = idList;
    }
}

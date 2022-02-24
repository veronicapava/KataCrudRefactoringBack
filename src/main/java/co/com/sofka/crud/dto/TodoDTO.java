package co.com.sofka.crud.dto;

public class TodoDTO {

        private Long id;
        private String name;
        private boolean completed;
        private String groupListId;

        public String getGroupListId() {
            return groupListId;
        }

        public void setGroupListId(String groupListId) {
            this.groupListId = groupListId;
        }

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

        //ToString


    @Override
    public String toString() {
        return "TodoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", groupListId='" + groupListId + '\'' +
                '}';
    }
}

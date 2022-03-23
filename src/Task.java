public class Task {

    int id = 0;
    String title = "Empty";
    String description = "Empty";
    String status = "None";
    String type = "Default";

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.type = "Task";
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

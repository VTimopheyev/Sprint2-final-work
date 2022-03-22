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

    public Task(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
}

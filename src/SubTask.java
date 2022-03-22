public class SubTask extends Task {

    int epicId;

    public SubTask(String title, String description, int epicId) {
        this.title = title;
        this.description = description;
        this.epicId = epicId;
    }
}

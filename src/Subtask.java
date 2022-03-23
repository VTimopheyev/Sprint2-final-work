public class Subtask extends Task {

    int epicId;

    public Subtask (String title, String description, int epicId) {
        super(title, description);
        this.epicId = epicId;
        this.type = "Subtask";
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", epicId='" + epicId + '\'' +
                '}';
    }
}

public class Subtask extends Task {

    int epicId;

    public Subtask (String title, String description, int epicId) {
        super(title, description);
        this.epicId = epicId;
    }
}

package issues;

public class Epic extends Task {

    public Epic(String title, String description) {
        super(title, description);
        setType("Epic");
    }


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }

}

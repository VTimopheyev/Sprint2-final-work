public class TaskManager {

    int idCount;

    HashMap<int id, Task task> tasks = new HashMap<>();
    HashMap<int id, Subtask subtask> subtasks = new HashMap<>();
    HashMap<int id, Epic epic> epics = new HashMap<>();

    public void createTask(Task task){
        idCount++;
        task.id = idCount;
        tasks.put(task.id, task);
    }

    public void updateTask(Task task){
        tasks.put(task.id, task);
    }

    public void deleteTask(Task task){
        tasks.remove(task.id);

    }




}

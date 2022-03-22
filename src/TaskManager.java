import java.util.HashMap;

public class TaskManager {

    int idCount;

    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();

    public void addTask(Task task){
        idCount++;
        task.id = idCount;
        task.status = "New";
        tasks.put(task.id, task);
    }

    public void updateTask(Task updatedTask){
        if(tasks.containsKey(updatedTask.id)) {
            tasks.put(updatedTask.id, updatedTask);
        }
    }

    public void deleteTask(Task taskToDelete){
        if(tasks.containsKey(taskToDelete.id)) {
            tasks.remove(taskToDelete.id);
        }
    }

    public void getAllTasksList(String type){
        switch(type){
            case "Task":
                for (Integer key : tasks.keySet()) {
                    System.out.println(tasks.get(key));
                }
                break;
            case "Epic":
                for (Integer key : epics.keySet()) {
                    System.out.println(epics.get(key));
                }
                break;
            case "Subtask":
                for (Integer key : subtasks.keySet()) {
                    System.out.println(subtasks.get(key));
                }
        }
    }

    public void deleteAllTasksOfType(String type){
        switch(type){
            case "Task":
                for (Integer key : tasks.keySet()) {
                    tasks.remove(key);
                }
                break;
            case "Epic":
                for (Integer key : epics.keySet()) {
                    epics.remove(key);
                }
                break;
            case "Subtask":
                for (Integer key : subtasks.keySet()) {
                    subtasks.remove(key);
                }
        }
    }

    public Object getTaskById(int id){
        Object object = new Object();

        if(tasks.containsKey(id)) {
            object = tasks.get(id);
        }else if(epics.containsKey(id)){
            object = epics.get(id);
        }else if(subtasks.containsKey(id)){
            object = subtasks.get(id);
        }

        return object;
    }




}

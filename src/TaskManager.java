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

    public void addEpic(Epic epic){
        idCount++;
        epic.id = idCount;
        epic.status = "New";
        epics.put(epic.id, epic);
    }

    public void updateEpic(Epic updatedEpic){

        if(epics.containsKey(updatedEpic.id)) {
            epics.put(updatedEpic.id, updatedEpic);
          }
    }

    public void updateEpicStatus(int id){
        if (checkSubtasksAllDoneInEpic(id)) {
            epics.get(id).status = "Done";
        } else if (!checkSubtasksInEpic(id) || checkSubtasksAllNewInEpic(id)) {
            epics.get(id).status = "New";
        } else if (checkSubtasksInEpic(id) && !checkSubtasksAllDoneInEpic(id)) {
            epics.get(id).status = "In progress";
        }
    }

    public boolean checkSubtasksInEpic(int id){
        boolean variable=false;
        for (int key : subtasks.keySet()){
             if (subtasks.get(key).epicId == id){
                 variable = true;
             }
         }
        return variable;
    }

    public boolean checkSubtasksAllDoneInEpic(int id){
        boolean variable=true;

        for (int key : subtasks.keySet()) {
            if (subtasks.get(key).epicId == id && !(subtasks.get(key).status).equals("Done")) {
                variable = false;
            }
        }
        return variable;
    }

    public boolean checkSubtasksAllNewInEpic(int id){
        boolean variable=true;

        for (int key : subtasks.keySet()) {
            if (subtasks.get(key).epicId == id && !(subtasks.get(key).status).equals("New")) {
                variable = false;
            }
        }
        return variable;
    }

    public void addSubtask(Subtask subtask){
        idCount++;
        subtask.id = idCount;
        subtask.status = "New";
        subtasks.put(subtask.id, subtask);
        if(epics.get(subtask.epicId).status.equals("Done")){
            epics.get(subtask.epicId).status = "In Progress";
        }
    }

    public void updateSubtask(Subtask updatedSubtask) {
        if(subtasks.containsKey(updatedSubtask.id)) {
            subtasks.put(updatedSubtask.id, updatedSubtask);
        }
        updateEpicStatus(updatedSubtask.epicId);
    }

    public Object getAllTasksOfType(String type){
        Object object = new Object();
        switch(type){
            case "Task":
                object = tasks;
                break;
            case "Epic":
                object = epics;
                break;
            case "Subtask":
                object = subtasks;
        }
        return object;
    }

    public void deleteAllTasksOfType(String type){
        switch(type){
            case "Task":
                tasks.clear();
                break;
            case "Epic":
                epics.clear();
                break;
            case "Subtask":
                subtasks.clear();
        }
    }

    public Object getIssueById(int id){
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

    public void deleteIssueById(int id){

        if(tasks.containsKey(id)) {
            tasks.remove(id);
        }else if(epics.containsKey(id)){
            for(int key : subtasks.keySet()){
                if(subtasks.get(key).epicId == id){
                    subtasks.remove(key);
                }
            }
            epics.remove(id);
        }else if(subtasks.containsKey(id)){
            int epicId;
            epicId = subtasks.get(id).epicId;
            subtasks.remove(id);
            updateEpicStatus(epicId);
        }

    }

    public HashMap getSubtasksOfEpic(int id) {
        HashMap<Integer, Subtask> relatedSubtasks = new HashMap<>();
        if(epics.containsKey(id)){
            for(int key : subtasks.keySet()){
                if(subtasks.get(key).epicId == id){
                    relatedSubtasks.put(key, subtasks.get(key));
                }
            }
        }
        return relatedSubtasks;
    }







}

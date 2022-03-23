import java.util.HashMap;

public class Main {



    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("First task", "Very first task");
        taskManager.addTask(task1);
        Task task2 = new Task("Second task", "Another one");
        taskManager.addTask(task2);

        Epic epic1 = new Epic("First epic", "Some description");
        taskManager.addEpic(epic1);
        Epic epic2 = new Epic("Second epic", "Some description");
        taskManager.addEpic(epic2);

        Subtask subtask1 = new Subtask("FirstSubtask", "Some description", epic1.id);
        Subtask subtask2 = new Subtask("Second subtask", "Some description", epic1.id);
        Subtask subtask3 = new Subtask("Second subtask", "Some description", epic2.id);
        taskManager.addSubtask(subtask1);
        taskManager.addSubtask(subtask2);
        taskManager.addSubtask(subtask3);

        System.out.println("Create issues:");
        System.out.println("Tasks:");
        System.out.println(taskManager.tasks);
        System.out.println("Epics:");
        System.out.println(taskManager.epics);
        System.out.println("Subtasks:");
        System.out.println(taskManager.subtasks);

        System.out.println("Changing parameters");
        Task updatedTask;
        updatedTask = task1;
        updatedTask.status = "In progress";
        taskManager.updateTask(updatedTask);
        System.out.println("Tasks:");
        System.out.println(taskManager.tasks);

        Epic updatedEpic;
        updatedEpic = epic1;
        updatedEpic.description = "New description";
        taskManager.updateEpic(updatedEpic);
        System.out.println("Epics:");
        System.out.println(taskManager.epics);

        Subtask updatedSubtask;
        updatedSubtask = subtask1;
        updatedSubtask.status = "Done";
        taskManager.updateSubtask(updatedSubtask);
        System.out.println("Subtasks:");
        System.out.println(taskManager.subtasks);
        System.out.println("Epics:");
        System.out.println(taskManager.epics);

        subtask2.status = "Done";
        taskManager.updateSubtask(subtask2);
        System.out.println("Epics:");
        System.out.println(taskManager.epics);

        System.out.println("List of all Epics:");
        System.out.println(taskManager.getAllTasksOfType(epic1.type));

        System.out.println("Issue by ID:");
        System.out.println(taskManager.getIssueById(2));

        System.out.println("Subtasks of Epic by ID:");
        System.out.println(taskManager.getSubtasksOfEpic(3));

        System.out.println("Delete by ID:");
        //taskManager.deleteIssueById(epic1.id);
        System.out.println("Epics:");
        System.out.println(taskManager.epics);
        System.out.println("Subtasks:");
        System.out.println(taskManager.subtasks);
        System.out.println("Subtasks of Epic by ID:");
        System.out.println(taskManager.getSubtasksOfEpic(3));



















    }
}

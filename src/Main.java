public class Main {



    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("First task", "Very first task");
        taskManager.addTask(task1);

        Task task2 = new Task("Second task", "Another one");
        taskManager.addTask(task2);

        Task task3 = new Task("Third task", "New one");
        taskManager.addTask(task3);

        Task task4 = new Task("Fourth task", "Good one");
        taskManager.addTask(task4);

        Task task5 = new Task("Fifth task", "Famous one");
        taskManager.addTask(task5);



        for (Integer key : taskManager.tasks.keySet()) {
            System.out.println((taskManager.tasks.get(key).id)+" "+(taskManager.tasks.get(key).description));
        }

        Task updatedTask = new Task(2, "Changed", "Some description", "Done");
        taskManager.updateTask(updatedTask);

        taskManager.deleteTask(task4);

        for (Integer key : taskManager.tasks.keySet()) {
            System.out.println((taskManager.tasks.get(key).id) + " " + (taskManager.tasks.get(key).status));
        }

        taskManager.getAllTasksList("Task");
        taskManager.deleteAllTasksOfType("Epic");

        for (Integer key : taskManager.tasks.keySet()) {
            System.out.println((taskManager.tasks.get(key).id) + " " + (taskManager.tasks.get(key).status));
        }


        System.out.println(taskManager.getTaskById(3));





    }
}

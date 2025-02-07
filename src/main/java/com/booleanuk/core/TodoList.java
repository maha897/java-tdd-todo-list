package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public class TodoList {
    public ArrayList<Task> tasks;

    public TodoList(){
        tasks = new ArrayList<>();
    }

    public void add(String task){
        if (!contains(task)){
            tasks.add(new Task(task));
        }
    }

    public void remove(String task){
        if (contains(task)){
            tasks.remove(find(task));
        } else {
            System.out.println("Task not in ToDo list.");
        }
    }

    public void showTasks(){
        System.out.println(tasks);
    }

    public void changeStatus(String task, boolean newStatus){
        find(task).status = newStatus;
    }

    public ArrayList<Task> completeTasks(){
        ArrayList<Task> complete = new ArrayList<>();
        for (Task t : tasks){
            if (t.status){
                complete.add(t);
            }
        }
        return complete;
    }

    public ArrayList<Task> incompleteTasks(){
        ArrayList<Task> incomplete = new ArrayList<>();
        for (Task t : tasks){
            if (!t.status){
                incomplete.add(t);
            }
        }
        return incomplete;
    }

    public void tasksAscending(){
        Collections.sort(tasks, Collections.reverseOrder());
        showTasks();
    }

    public void tasksDescending(){
        Collections.sort(tasks);
        showTasks();
    }

    public boolean status(String task){
        return find(task).status;
    }

    public boolean contains(String task, ArrayList<Task> tasks){

        for (Task t : tasks){
            if (t.equals(task)){
                return true;
            }
        }
        System.out.println("This task is not in the ToDo list.");
        return false;
    }

    public boolean contains(String task){
        return contains(task, this.tasks);
    }

    public Task find(String task){
        for (Task t : tasks){
            if (t.equals(task)){
                return t;
            }
        }
        System.out.println("This task is not in the ToDo list.");
        return null;
    }
}

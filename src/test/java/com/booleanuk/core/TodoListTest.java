package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void testAdd(){
        TodoList todo = new TodoList();

        Assertions.assertTrue(todo.tasks.isEmpty());

        todo.add("buy milk");
        todo.add("brush teeth");
        
        Assertions.assertTrue(todo.contains("buy milk"));
        Assertions.assertTrue(todo.contains("brush teeth"));
    }

    @Test
    public void testTaskStatus(){
        TodoList todo = new TodoList();
        todo.add("wash toilet");
        todo.add("clean roof");

        Assertions.assertFalse(todo.status("wash toilet"));
        Assertions.assertFalse(todo.status("clean roof"));

        todo.changeStatus("wash toilet", true);

        Assertions.assertTrue(todo.status("wash toilet"));
    }

    @Test
    public void testCompleteAndIncomplete(){
        TodoList todo = new TodoList();
        todo.add("pet cat");
        todo.add("scream");
        todo.add("tie shoelaces");
        todo.changeStatus("pet cat", true);
        todo.changeStatus("scream", true);

        Assertions.assertEquals(2, todo.completeTasks().size());
        Assertions.assertEquals(1, todo.incompleteTasks().size());
        Assertions.assertTrue(todo.contains("scream", todo.completeTasks()));
        Assertions.assertFalse(todo.contains("scream", todo.incompleteTasks()));
    }

    @Test
    public void testSearch(){
        TodoList todo = new TodoList();
        todo.add("clip nails");
        todo.add("vacuum hair");

        Assertions.assertTrue(todo.contains("clip nails"));
        Assertions.assertFalse(todo.contains("lawn mow"));
        Assertions.assertTrue(todo.contains("vacuum hair"));
    }

    @Test
    public void testRemove(){
        TodoList todo = new TodoList();
        todo.add("ride horse");
        todo.add("appreciate boyfriend");

        Assertions.assertTrue(todo.contains("ride horse"));

        todo.remove("ride horse");

        Assertions.assertFalse(todo.contains("ride horse"));
    }
    
    @Test 
    public void testRemoveFromEmptyListAndNonExistingTasks(){
        TodoList todo = new TodoList();
        todo.remove("rob bank");
        // TODO ========================================================
    }

    @Test
    public void testAscending(){
        TodoList todo = new TodoList();
        todo.add("acrobatics");
        todo.add("arson");
        todo.add("brunch");
        todo.tasksAscending();

        Assertions.assertTrue(todo.tasks.get(0).description.equals("brunch"));
        Assertions.assertTrue(todo.tasks.get(2).description.equals("acrobatics"));
    }

    @Test
    public void testDescending(){
        TodoList todo = new TodoList();
        todo.add("basketball");
        todo.add("knit");
        todo.add("drink water");
        todo.add("complain");
        todo.add("arrest the bad guys");
        todo.tasksDescending();

        Assertions.assertTrue(todo.tasks.get(0).description.equals("arrest the bad guys"));
        Assertions.assertTrue(todo.tasks.get(4).description.equals("knit"));

    }
}

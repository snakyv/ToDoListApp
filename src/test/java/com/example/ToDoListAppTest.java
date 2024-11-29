package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javafx.collections.ObservableList;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ToDoListAppTest {
    private ToDoListApp app;

    @BeforeMethod
    public void setUp() throws Exception {
        app = new ToDoListApp();
        Platform.startup(() -> {
            Stage stage = new Stage();
            app.start(stage);
        });
    }

    @Test
    public void testAddTask() {
        Platform.runLater(() -> {
            app.addTask("New Task");
            ObservableList<Task> tasks = app.getTasks();
            Assert.assertEquals(1, tasks.size());
            Assert.assertEquals("New Task", tasks.get(0).getName());
        });
    }

    @Test
    public void testMarkTaskAsCompleted() {
        Platform.runLater(() -> {
            app.addTask("Task to Mark");
            app.getTasks().get(0).setCompleted(true);
            Assert.assertTrue(app.getTasks().get(0).isCompleted());
        });
    }
}









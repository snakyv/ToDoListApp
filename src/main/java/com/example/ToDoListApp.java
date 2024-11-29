package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoListApp extends Application {
    private ObservableList<Task> tasks;

    @Override
    public void start(Stage stage) {
        tasks = FXCollections.observableArrayList();
        ListView<Task> taskList = new ListView<>(tasks);
        TextField taskInput = new TextField();
        Button addButton = new Button("Add Task");
        Button markCompletedButton = new Button("Mark as Completed");

        addButton.setOnAction(e -> addTask(taskInput.getText()));
        markCompletedButton.setOnAction(e -> {
            Task selectedTask = taskList.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                selectedTask.setCompleted(true);
                taskList.refresh();
            }
        });

        VBox layout = new VBox(10, taskInput, addButton, markCompletedButton, taskList);
        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.setTitle("To Do List");
        stage.show();
    }

    public void addTask(String taskName) {
        if (!taskName.isEmpty()) {
            tasks.add(new Task(taskName));
        }
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return name + (completed ? " (completed)" : "");
    }
}










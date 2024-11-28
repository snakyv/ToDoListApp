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
    private ObservableList<String> tasks;

    @Override
    public void start(Stage stage) {
        tasks = FXCollections.observableArrayList();
        ListView<String> taskList = new ListView<>(tasks);
        TextField taskInput = new TextField();
        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove Selected Task");

        addButton.setOnAction(e -> {
            if (!taskInput.getText().isEmpty()) {
                tasks.add(taskInput.getText());
                taskInput.clear();
            }
        });

        removeButton.setOnAction(e -> {
            String selectedTask = taskList.getSelectionModel().getSelectedItem();
            tasks.remove(selectedTask);
        });

        VBox layout = new VBox(10, taskInput, addButton, removeButton, taskList);
        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.setTitle("To Do List");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package view;

// The user interface for a ToDo List application of your own design.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is a user interface to edit a ToDoList
 * 
 */
public class ToDoListGUI extends Application {

  public static void main(String[] args) {
    launch();
  }

  GridPane pane = new GridPane();

  @Override
  public void start(Stage stage) {
    getSavedToDosOrNot();
    var scene = new Scene(pane, 800, 200);
    stage.setScene(scene);
    stage.show();
  }

  private void getSavedToDosOrNot() {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("ToDo List");
    alert.setHeaderText("Click cancel to start with zero todos");
    alert.setContentText("Start with hard coded saved ToDo List?");

    var result = alert.showAndWait();
    if (result.get() == ButtonType.OK) {
      System.out.println("Read from serialized data file");
    } else {
      System.out.println("Start with an empty to do list");
    }

  }
}
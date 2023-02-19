package tests;

// Save a hard-coded serialized file containing three ToDos
// author: Rick Mercer

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class hardCodeASerializedFile {

  public static void main(String[] args) {
     write();
  }

  public static void write() {
    FileOutputStream outFile = null;
    try {
      outFile = new FileOutputStream("optionalStartList");
      ObjectOutputStream outputStream = new ObjectOutputStream(outFile);
     
      ArrayList<String> toDos = new ArrayList<>();
      toDos.add("Plan Spring Break");
      toDos.add("Start ToDoList ASAP");
      toDos.add("Complete ToDoList");
      
      outputStream.writeObject(toDos);
      
      // Do NOT forget to close the output stream!
      outputStream.close();
      
    } catch (IOException ioe) {
      System.out.println("Error writing objects to disk to file: " + outFile);
      
    }
  }   
}
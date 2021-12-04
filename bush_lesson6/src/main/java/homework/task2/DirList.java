package homework.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
  public static void main(String[] args) {


    try(Stream<Path> files = Files.list(Paths.get("bush_lesson6/src/main/resources"))){ // Add Try with resources here

        System.out.println("\n=== Dir list ===");
        // Print directory list here
      files.forEach(System.out::println);
    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}

package homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("bush_lesson6/src/main/java/homework/task1/hamlet.txt");

        try{
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream()
                    .filter(line->line.contains("Ros.")).forEach(System.out::println);

            // Filter for Guil. here
            System.out.println("\n=== Guildenstern ===");
            // Filter for Ros. here
            fileArr.stream()
                    .filter(line->line.contains("Guil.")).forEach(System.out::println);
            

        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }
    } 
}

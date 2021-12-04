package homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {
    
    public static void main(String[] args) {
        try(Stream<String> lines = Files.lines(Paths.get("bush_lesson6/src/main/java/homework/task1/hamlet.txt"))){ // Create Try with Resources here
            
            System.out.println("\n=== Entire File ===");
            // print lines here
            lines.forEach(System.out::println);
            
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}

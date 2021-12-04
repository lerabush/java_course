package homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class P04NioReadAll {
    public static void main(String[] args) {

        Path file = Paths.get("bush_lesson6/src/main/java/homework/task1/hamlet.txt");
        List<String> fileArr;
        try {
            // Read fileinto array here
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Lord Count ===");
            long wordCount = 0; // Replace with your pipeline
            wordCount = fileArr.stream().filter(line -> line.toLowerCase().contains("lord")).count();
            System.out.println("Word count: " + wordCount);
            wordCount = 0;
            System.out.println("\n=== Prison Count ===");
            wordCount = fileArr.stream().filter(line -> line.toLowerCase().contains("prison")).count();
            // Replace with your pipeline"bush_lesson6/src/main/java/homework/task1/hamlet.txt"
            System.out.println("Word count: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

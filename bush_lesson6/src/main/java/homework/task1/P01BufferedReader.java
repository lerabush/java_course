package homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01BufferedReader {

    public static void main(String[] args) {

        try (BufferedReader bReader =
                     new BufferedReader(new FileReader("bush_lesson6/src/main/java/homework/task1/hamlet.txt"))) {
            System.out.println("=== Entire File ===");
            bReader.lines()
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

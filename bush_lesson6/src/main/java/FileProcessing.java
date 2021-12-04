import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
//task 1
public class FileProcessing {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public FileProcessing(String name) {
        this.fileName = name;
    }

    public Long countWord() {
        Scanner scanner = new Scanner(System.in);
        String lineToFind = scanner.nextLine();
        Long count = 0L;
        try(BufferedReader reader = new BufferedReader(new FileReader(this.getFileName()))){
            count = reader.lines().filter(line->line.trim().equals(lineToFind)).count();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    public static void main(String[] args){
        FileProcessing proc = new FileProcessing("bush_lesson6/src/main/resources/new.txt");
        System.out.println("Number of entries:"+ proc.countWord());
    }

}

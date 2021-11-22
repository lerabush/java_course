import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionsExample {
    public static <T> void processIndexOutOfBounds(List<T> list, Integer index) throws IndexOutOfBoundsException {
        System.out.println("\nIndex is out of bounds processing");
        try {
            System.out.println(list.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processFileNotFound(String path) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void processArithmeticException(int num) throws ArithmeticException {
        System.out.println("\n Arithmetic exception");
        try {
            Double res = Math.log(num);
            System.out.println("Result: " + res);
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static void processIOException(String path, String text) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static <T> void processNullPointerException(ArrayList<T> list,T item){
        System.out.println("\n Null pointer exception");
        try{
            list.add(item);
        }catch(NullPointerException ex){
            System.out.println(ex.getMessage());
            System.out.println("Can't add an element to a null list");
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> strings = Arrays.asList("hello", "java", "kotlin");
        ArrayList<String> list1 = null;
        processIndexOutOfBounds(strings, 1);
        processIndexOutOfBounds(strings, 10);
        processNullPointerException(list1,"Hi");
        processFileNotFound("C:/Users/mi/IdeaProjects/java_course/bush_lesson4/src/main/resources/newFile.txt");
        processFileNotFound("C:/Users/mi/IdeaProjects/java_course/bush_lesson4/src/main/resources/right.txt");
        processArithmeticException(-5);
        processIOException("C:/Users/mi/IdeaProjects/java_course/bush_lesson4/src/main/resources/newE.txt","hello");
        Cat cat = new Cat();
        processClassCast(cat);
        //stackOverFlow();
        //Integer[] array = new Integer[1000000000];

    }
    public static void stackOverFlow(){
          stackOverFlow();

    }
    public static void processClassCast(Animal animal) throws ClassCastException{
        try{
            Dog dog = (Dog) animal;
        }catch(ClassCastException ex){
            System.out.println(ex.getMessage());
        }
    }

}
class Animal{}
class Cat extends Animal{}
class Dog extends Animal {}

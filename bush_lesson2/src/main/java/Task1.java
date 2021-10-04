import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args){
        Map<String,Integer> occurMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        for(String i:words){
            if(!occurMap.containsKey(i)){
                occurMap.put(i,1);
            }
            else occurMap.put(i,occurMap.get(i)+1);
        }
        System.out.println(occurMap.toString());
    }
}
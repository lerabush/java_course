import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        Set<String> set = new LinkedHashSet<>(Arrays.asList(words));
        System.out.println(set.toString());

        Map<String, Integer> map2 = new LinkedHashMap<>();

        for (String item : words) {
            if (!map2.containsKey(item)) {
                map2.put(item, 1);
            } else map2.put(item, map2.get(item) + 1);
        }
        System.out.println(map2.toString());
    }

}

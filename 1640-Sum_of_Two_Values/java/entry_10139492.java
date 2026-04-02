import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class entry_10139492 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        long[] arr = Stream.of(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = Long.parseLong(first[0]);
        long target = Long.parseLong(first[1]);

        Map<Long, Long> map = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], (long) i);
            } else {
                System.out.println((map.get(target - arr[i]) + 1) + " " + (i + 1));
                flag = true;
                break; // Exit the loop once the pair is found
            }
        }
        if (!flag) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
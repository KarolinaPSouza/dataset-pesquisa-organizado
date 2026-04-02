import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class entry_7604408 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = x - arr[i];
            if (valueToIndex.containsKey(complement)) {
                int j = valueToIndex.get(complement);
                System.out.println((j + 1) + " " + (i + 1));
                return;
            }
            valueToIndex.put(arr[i], i);
        }

        System.out.println("IMPOSSIBLE");
    }
}
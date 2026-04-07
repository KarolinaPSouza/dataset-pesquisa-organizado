import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class entry_8137326 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of values
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        int distinctCount = countDistinctValues(values);
        System.out.println(distinctCount);

        scanner.close();
    }

    private static int countDistinctValues(int[] values) {
        Set<Integer> distinctSet = new HashSet<>();

        for (int value : values) {
            distinctSet.add(value);
        }

        return distinctSet.size();
    }
}

import java.util.Scanner;

public class entry_12689564 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }

        long maxSum = array[0];
        long currentSum = array[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
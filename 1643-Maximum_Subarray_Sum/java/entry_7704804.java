//package algos_bonus_pro;

import java.util.Scanner;

public class entry_7704804 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextLong();
        }

        long max_1 = arr[0];
        long max_2 = arr[0];

        for (int i = 1; i < n; i++) {
            max_1 = Math.max(arr[i], max_1 + arr[i]);
            max_2 = Math.max(max_2, max_1);
        }

        System.out.println(max_2);
    }
}

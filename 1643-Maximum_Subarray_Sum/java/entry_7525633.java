//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class entry_7525633 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int l = scan.nextInt();
//        int r = scan.nextInt();
//
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scan.nextInt();
//        }
//        int[] findPrefix = findPrefixSum(a); //b
//
//        for (int i = 0; i < n + 1; i++) {
//            System.out.print(findPrefix[i] + " ");
//        }
//        System.out.println();
//        System.out.println(findPrefix[r] - findPrefix[l]);
//
//    }
//    public static int[] findPrefixSum(int[] a) {
//        int n = a.length;
//        int[] b = new int[n + 1];
//
//        for (int i = 0; i < n + 1; i++) {
//            b[i] = 0;
//        }
//
//        for (int i = 0; i < n; i++) {
//            b[i + 1] = b[i] + a[i];
//        }
//        return b;
//    }
//}

import java.util.Scanner;

public class entry_7525633 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }

        long maxSum = Long.MIN_VALUE;
        long minPrefixSum = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += array[i];
            maxSum = Math.max(maxSum, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }

        System.out.println(maxSum);
    }
}
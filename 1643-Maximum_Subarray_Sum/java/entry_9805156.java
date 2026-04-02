import java.io.*;
import java.util.*;

public class entry_9805156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }



        long maxSum = findMaxSubarraySum(array);

        System.out.println(maxSum);
    }
     public static long findMaxSubarraySum(int[] array) {
        long maxEndingHere = array[0];
        long maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
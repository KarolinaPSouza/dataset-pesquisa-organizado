import java.io.*;
import java.util.*;

public class entry_7548326 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        long max = Integer.MIN_VALUE;
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += arr[i];
            max = Math.max(max, curr);
            if (curr < 0) {
                curr = 0;
            }
        }

        System.out.println(max);
    }
}
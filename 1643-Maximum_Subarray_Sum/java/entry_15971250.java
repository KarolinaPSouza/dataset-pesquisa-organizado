import java.util.*;
import java.io.*;

public class entry_15971250 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum = Math.max(arr[i], sum + arr[i]);

            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }

        }

        System.out.println(maxSum);
    }
}
import java.util.*;
import java.io.*;

public class entry_13910642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
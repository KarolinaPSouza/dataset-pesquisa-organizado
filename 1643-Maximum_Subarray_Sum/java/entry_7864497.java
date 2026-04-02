//package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_7864497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i], arr[i]+arr[i-1]);
        }

        long max = arr[0];
        for(long i: arr) {
            if (i>max)
                max = i;
        }

        System.out.println(max);
    }
}
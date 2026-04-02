//package cses;
import java.io.*;
import java.util.*;
public class entry_7025615 {
    public static void main(String[] args) throws IOException {
        (new entry_7025615()).start();
    }
    public void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] x = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i<N; i++) arr[i]=Integer.parseInt(x[i]);
        long best_sum = arr[0];
        long current_sum = 0;
        for (long num : arr) {
            current_sum=Math.max(num, current_sum+num);
            best_sum = Math.max(best_sum, current_sum);
        }
        System.out.println(best_sum);
    }
}
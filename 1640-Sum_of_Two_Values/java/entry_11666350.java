/*You are given an array arr[] of N integers, and your task is to find 
two different indices whose sum is X. */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class entry_11666350 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        st = new StringTokenizer(r.readLine());
        for (int i=0; i<n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i+1;
        }
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        int left = 0;
        int right = n-1;
        boolean done = false;
        while (left<right) {
            int sum = arr[left][0]+arr[right][0];
            if (sum==target) {
                pw.println("" + arr[left][1] + " " + arr[right][1]);
                done=true;
                break;
            } else if (sum<target) {
                left++;
            } else {
                right--;
            }
        }
        if (!done) {
            pw.println("IMPOSSIBLE");
        }
        pw.close();
    }
}

import java.io.*;
import java.util.*;

public class entry_11702270 {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new FileReader("cdf.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long maxSum = arr[0];
        long currentSum = 0;
        long minPrefix = 0;

        for (long e : arr) {
            currentSum += e;
            maxSum = Math.max(maxSum, currentSum - minPrefix);
            minPrefix = Math.min(minPrefix, currentSum);
        }

        pw.println(maxSum);

        br.close();
        pw.close();

    }
}
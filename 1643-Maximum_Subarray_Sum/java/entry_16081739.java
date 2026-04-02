import java.io.*;
import java.util.*;

public class entry_16081739{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long maxSoFar = Long.MIN_VALUE;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());

            currentSum = Math.max(x, currentSum + x);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        System.out.println(maxSoFar);
    }
}

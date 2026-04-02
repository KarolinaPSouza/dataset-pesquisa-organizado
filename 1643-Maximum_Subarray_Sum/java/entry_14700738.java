import java.util.*;
import java.io.*;
public class entry_14700738 {
    public static void main(String args[]) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter written = new PrintWriter(System.out);
        // PrintWriter written = new PrintWriter("breedflip.out");
        int n = Integer.parseInt(br.readLine());
        long prefix[] = new long[n+1];
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + Integer.parseInt(line[i]);
        }

        // get prefix sum min
        // prefix[1] = the prefix sum of 
        // prefSum[1]  = the minimum prefSum before it
        // max = max(max, prefix)
        long max = -(Long.MAX_VALUE);
        long[] prefSum = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefSum[i+1] = Math.min(prefSum[i], prefix[i]);
            max = Math.max(prefix[i+1] - prefSum[i+1], max);
        }

        written.println(max);
        written.close();
    }
}
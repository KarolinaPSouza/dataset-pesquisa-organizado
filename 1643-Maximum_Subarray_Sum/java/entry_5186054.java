import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_5186054 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());

//        long[] max_with_i = new long[N];
//        long highest = Long.MIN_VALUE;
//        StringTokenizer st = new StringTokenizer(r.readLine());
//        for (int i = 0; i < N; i ++) {
//            int next = Integer.parseInt(st.nextToken());
//            if (i == 0)
//                max_with_i[0] = next;
//            else
//                max_with_i[i] = Math.max(next, max_with_i[i-1] + next);
//            highest = Math.max(max_with_i[i], highest);
//        }
        long runningPrefixSum = 0;
        long lowestPrefixSum = (long) 0;
        long highest = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            runningPrefixSum += Long.parseLong(st.nextToken());
            highest = Math.max(highest, runningPrefixSum - lowestPrefixSum);
            lowestPrefixSum = Math.min(runningPrefixSum, lowestPrefixSum);
        }

        pw.println(highest);
        pw.close();
    }
}
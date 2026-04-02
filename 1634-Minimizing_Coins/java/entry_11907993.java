import java.util.*;
import java.io.*;

public class entry_11907993 {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        st = new StringTokenizer(f.readLine());

        for (int n = 0; n < N; n++) coins[n] = Integer.parseInt(st.nextToken());

        int[] mins = new int[M+1];
        mins[0] = 0;
        for (int m = 1; m <= M; m++) {
            mins[m] = Integer.MAX_VALUE;
            for (int n = 0; n < N; n++) {
                if (coins[n] <= m && mins[m-coins[n]] < Integer.MAX_VALUE)
                    mins[m] = Math.min(mins[m], mins[m-coins[n]] + 1);
            }
        }
        if (mins[M] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(mins[M]);
    }
}
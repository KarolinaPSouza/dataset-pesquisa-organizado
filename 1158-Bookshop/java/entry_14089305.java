import java.io.*;
import java.util.*;
public class entry_14089305 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] price = new int[n];
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) price[i] = fr.nextInt();
        for (int i = 0; i < n; i++) pages[i] = fr.nextInt();
        int[] prev = new int[x+1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[x+1];
            for (int j = 1; j <= x; j++) {
                curr[j] = prev[j];
                if (j - price[i-1] >= 0) curr[j] = Math.max(curr[j],prev[j-price[i-1]]+pages[i-1]);
            }
            prev = curr;
        }
        out.println(prev[x]);
        out.close();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
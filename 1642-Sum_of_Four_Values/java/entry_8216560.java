
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_8216560 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int x = sc.nextInt();
        long[][] arr = new long[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));
        for(int i = 3; i < n; i++) {
            for(int j = i - 1; j > 1; j--) {
                int l = 0;
                int r = j - 1;
                while(l < r) {
                    long sum = arr[l][0] + arr[r][0] + arr[i][0] + arr[j][0];
                    if(sum == x) {
                        pw.println(arr[l][1] + " " + arr[r][1] + " " + arr[i][1] + " " + arr[j][1]);
                        pw.close();
                        return;
                    } else if(sum < x) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        pw.println("IMPOSSIBLE");
        pw.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        private String next() {
            while(!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {}
            }
            return st.nextToken();
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_11480971 {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int x = in.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i][0] == arr[i - 1][0])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j][0] == arr[j - 1][0])
                    continue;
                int si = j + 1, ei = n - 1;
                while (si < ei) {
                    long sum = arr[i][0] + arr[j][0] + arr[si][0] + arr[ei][0];
                    if (sum > x)
                        ei--;
                    else if (sum < x)
                        si++;
                    else {
                        out.println(arr[i][1] + " " + arr[j][1] + " " + arr[si][1] + " " + arr[ei][1]);
                        out.flush();
                        return;
                    }
                }
            }
        }

        out.println("IMPOSSIBLE");
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
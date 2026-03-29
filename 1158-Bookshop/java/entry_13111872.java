import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_13111872 {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException{
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int x = reader.nextInt();

        int[] price = new int[n+1];
        for (int i = 1; i <=n; i++) {
            price[i] = reader.nextInt();
        }

        int[] pages = new int[n+1];
        for (int i = 1; i <=n; i++) {
            pages[i] = reader.nextInt();
        }

        int[][] total_pages = new int[n+1][x+1];
        total_pages[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                total_pages[i][j] = total_pages[i-1][j];
                if (price[i] <= j) {
                    total_pages[i][j] = Math.max(total_pages[i][j], pages[i] + total_pages[i-1][j - price[i]]);
                }
            }
        }

        System.out.println(total_pages[n][x]);
    }
}
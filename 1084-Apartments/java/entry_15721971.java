import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15721971 {
    public static void main(String[] args) {
        FastScanner sc = new  FastScanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();

        long[] Array1= new long[n];
        long[] Array2 = new long[m];

        for (int i = 0; i < n; i++) {
            Array1[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            Array2[i] = sc.nextLong();
        }
        Arrays.sort(Array1);
        Arrays.sort(Array2);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (Array2[j] < Array1[i] - k) {
                j++; //apartment is small
            } else if (Array2[j] > Array1[i] + k) {
                i++; //apartment  is large
            } else {
                count++; //match 
                i++;
                j++;
            }
        }

        System.out.println(count);
    }

    // Fast Scanner using InputStream + StringTokenizer
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


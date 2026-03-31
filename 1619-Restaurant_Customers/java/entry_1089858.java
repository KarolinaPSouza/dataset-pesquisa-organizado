import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.util.SortedMap;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tarek
 */
public class entry_1089858 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        RestaurantCustomers solver = new RestaurantCustomers();
        solver.solve(1, in, out);
        out.close();
    }

    static class RestaurantCustomers {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            SortedMap<Integer, Boolean> k = new TreeMap<>();
            while (n-- > 0) {
                int x = in.nextInt();
                int y = in.nextInt();
                k.put(x, true);
                k.put(y, false);
            }
            Set s = k.entrySet();
            Iterator i = s.iterator();
            long ans = 0, mx = 0;
            while (i.hasNext()) {
                Map.Entry m = (Map.Entry) i.next();
                if ((boolean) m.getValue() == true) {
                    ans++;
                    mx = Math.max(ans, mx);
                } else {
                    ans--;
                }
            }
            out.println(mx);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

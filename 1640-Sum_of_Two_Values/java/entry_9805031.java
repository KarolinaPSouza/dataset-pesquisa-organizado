import java.io.*;
import java.util.*;

public class entry_9805031 {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = reader.nextInt();
        int x = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }

        // Map to store value and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = x - a[i];
            if (map.containsKey(complement)) {
                out.println((map.get(complement) + 1) + " " + (i + 1));
                out.flush();
                return;
            }
            map.put(a[i], i);
        }

        out.println("IMPOSSIBLE");
        out.flush();
    }
}

class FastReader {
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
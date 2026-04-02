import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15371491 {
    static class FR {
        BufferedReader r;
        StringTokenizer t;

        public FR() {
            r = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (t == null || !t.hasMoreElements()) {
                try {
                    t = new StringTokenizer(r.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return t.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FR in = new FR();

        int n = in.nextInt();
        int s = in.nextInt();

        HashMap<Integer, Integer> m = new HashMap<>();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        boolean ok = false;

        for (int i = 0; i < n; i++) {
            int need = s - a[i];
            if (m.containsKey(need)) {
                System.out.println(m.get(need) + " " + (i + 1));
                ok = true;
                break;
            }
            m.put(a[i], i + 1);
        }

        if (!ok) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
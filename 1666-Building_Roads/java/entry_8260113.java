
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class entry_8260113 {

    static int[] ds;

    public static int find(int u) {
        if(ds[u] < 0)   return u;
        return ds[u] = find(ds[u]);
    }

    public static boolean unite(int u, int v) {
        u = find(u); v = find(v);
        if(u == v)  return false;
        if(ds[u] < ds[v]) {
            ds[u] += ds[v];
            ds[v] = u;
        } else {
            ds[v] += ds[u];
            ds[u] = v;
        }
        return true;
    }

    public static void main(String[] args) {
        FS sc = new FS();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.readInt();
        int m = sc.readInt();
        ds = new int[n];
        Arrays.fill(ds, -1);

        for(int i = 0; i < m; i++) {
            unite(sc.readInt() - 1, sc.readInt() - 1);
        }

        int count = 0;
        List<Integer> r = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(ds[i] < 0) {
                count++;
                r.add(i + 1);
            }
        }

        pw.println(count - 1);
        for(int i = 1; i < count; i++) {
            pw.println(r.get(i - 1) + " " + r.get(i));
        }
        pw.close();
    }

    static int find(int[] roots, int node) {
        if(roots[node] == -1) {
            return node;
        }
        return roots[node] = find(roots, roots[node]);
    }

    static class FS {
        BufferedReader br;
        StringTokenizer st;

        public FS() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        String next() {
            while(!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException ignored) {}
            }
            return st.nextToken();
        }

        int readInt() {
            return Integer.parseInt(next());
        }
    }
}
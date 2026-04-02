import java.util.*;
import java.io.*;

public class entry_8863594 {
    static int n;
    static long INF = (long) 1e16;
    static long[] prefix;
    static long[] sum;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        FS sc = new FS();

        n = sc.readInt();
        int q = sc.readInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.readInt();
        }
        while(Integer.bitCount(n) != 1) {
            n++;
        }
        prefix = new long[2 * n];
        sum = new long[2 * n];
        for(int i = 0; i < arr.length; i++) {
            prefix[i + n] = Math.max(0, arr[i]);
            sum[i + n] = arr[i];
        }
        for(int i = n - 1; i > 0; i--) {
            sum[i] = sum[2 * i] + sum[2 * i + 1];
            prefix[i] = Math.max(prefix[2 * i], sum[2 * i] + prefix[2 * i + 1]);
        }

        while(q-- > 0) {
            int t = sc.readInt();
            if(t == 1) {
                int k = sc.readInt() - 1;
                int x = sc.readInt();
                update(k, x);
            } else {
                int a = sc.readInt() - 1;
                int b = sc.readInt() - 1;
                pw.println(query(1, 0, n - 1, a, b)[1]);
            }
        }

        pw.close();
    }

    static long[] query(int v, int nl, int nr, int ql, int qr) {
        if(nl >= ql && nr <= qr) {
            return new long[]{ sum[v], prefix[v] };
        }
        if(nr < ql || nl > qr) {
            return new long[2];
        }
        int m = nl + (nr - nl) / 2;
        long[] lres = query(v * 2, nl, m, ql, qr);
        long[] rres = query(v * 2 + 1, m + 1, nr, ql, qr);
        return new long[]{ lres[0] + rres[0], Math.max(lres[1], lres[0] + rres[1]) };
    }

    static void update(int pos, int val) {
        sum[pos + n] = val;
        prefix[pos + n] = Math.max(0, val);
        for(int i = (pos + n) / 2; i > 0; i /= 2) {
            sum[i] = sum[2 * i] + sum[2 * i + 1];
            prefix[i] = Math.max(prefix[2 * i], sum[2 * i] + prefix[2 * i + 1]);
        }
    }

    static void dbg(Object... args) {
        List<String> lst = new ArrayList<>();
        for(Object arg : args) {
            if(arg.getClass().isArray()) {
                lst.add(Arrays.toString((int[]) arg));
            } else {
                lst.add(arg.toString());
            }
        }
        System.out.println("[" + String.join(", ", lst) + "]");
    }

    static void dbg(Object obj) {
        System.out.println(obj);
    }

    static void dbg(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void dbg(boolean[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void dbg(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void dbg(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void dbg(int[][] arr) {
        List<String> lst = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            lst.add(Arrays.toString(arr[i]));
        }
        System.out.println("[" + String.join(",", lst) + "]");
    }

    static void dbg(long[][] arr) {
        List<String> lst = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            lst.add(Arrays.toString(arr[i]));
        }
        System.out.println("[" + String.join(",", lst) + "]");
    }

    static void dbg(List<int[]> lst) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < lst.size(); i++) {
            res.add(Arrays.toString(lst.get(i)));
        }
        System.out.println("[" + String.join(",", res) + "]");
    }

    static void dbg(Queue<int[]> q) {
        List<int[]> lst = new ArrayList<>(q);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < lst.size(); i++) {
            res.add(Arrays.toString(lst.get(i)));
        }
        System.out.println("[" + String.join(",", res) + "]");
    }

    static void dbgSegmentTree(long[] tree) {
        int n = tree.length;
        List<List<String>> res = new ArrayList<>();
        for(int level = 2; level <= n; level = (level << 1)) {
            List<String> curr = new ArrayList<>();
            int c = n / level;
            for(int j = c; j < c + c; j++) {
                curr.add(tree[j] + "");
            }
            res.add(curr);
        }
        Collections.reverse(res);
        for (List<String> re : res) {
            dbg(re);
        }
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

        long readLong() {
            return Long.parseLong(next());
        }
    }
}
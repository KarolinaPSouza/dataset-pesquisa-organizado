import java.io.*;
import java.util.*;

public class entry_15515316 {

    static class Node {
        long sum, pref;

        Node() {
            this.sum = 0;
            this.pref = 0;
        }

        Node(long val) {
            this.sum = val;
            this.pref = Math.max(0, val);
        }

        static Node merge(Node a, Node b) {
            Node res = new Node();
            res.sum = a.sum + b.sum;
            res.pref = Math.max(a.pref, a.sum + b.pref);
            return res;
        }
    }

    static class SegTree {
        int n;
        Node[] tree;

        SegTree(long[] arr, int n) {
            this.n = n;
            tree = new Node[4 * n];
            build(arr, 1, 1, n);
        }

        void build(long[] arr, int v, int tl, int tr) {
            if (tl == tr) {
                tree[v] = new Node(arr[tl]);
            } else {
                int tm = (tl + tr) / 2;
                build(arr, v*2, tl, tm);
                build(arr, v*2+1, tm+1, tr);
                tree[v] = Node.merge(tree[v*2], tree[v*2+1]);
            }
        }

        void update(int v, int tl, int tr, int pos, long val) {
            if (tl == tr) {
                tree[v] = new Node(val);
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v*2, tl, tm, pos, val);
                else
                    update(v*2+1, tm+1, tr, pos, val);

                tree[v] = Node.merge(tree[v*2], tree[v*2+1]);
            }
        }

        Node query(int v, int tl, int tr, int l, int r) {
            if (l > r) return new Node(); // empty node
            if (l == tl && r == tr) return tree[v];

            int tm = (tl + tr) / 2;
            Node left = query(v*2, tl, tm, l, Math.min(r, tm));
            Node right = query(v*2+1, tm+1, tr, Math.max(l, tm+1), r);
            return Node.merge(left, right);
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int q = fs.nextInt();

        long[] arr = new long[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = fs.nextInt();

        SegTree st = new SegTree(arr, n);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int type = fs.nextInt();

            if (type == 1) {
                int k = fs.nextInt();
                long u = fs.nextInt();
                st.update(1, 1, n, k, u);
            } 
            else {
                int a = fs.nextInt();
                int b = fs.nextInt();
                sb.append(st.query(1, 1, n, a, b).pref).append('\n');
            }
        }

        System.out.print(sb);
    }

    // Faster input
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                ptr = 0;
                len = in.read(buffer);
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return val * sign;
        }
    }
}
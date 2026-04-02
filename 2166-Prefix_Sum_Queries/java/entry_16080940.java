import java.io.*;

public class entry_16080940 {

    static class Node {
        long sum;
        long pref;

        Node(long sum, long pref) {
            this.sum = sum;
            this.pref = pref;
        }
    }

    static class SegTree {
        int n;
        Node[] tree;

        SegTree(long[] arr) {
            n = arr.length;
            tree = new Node[4 * n];
            build(1, 0, n - 1, arr);
        }

        void build(int idx, int l, int r, long[] arr) {
            if (l == r) {
                long v = arr[l];
                tree[idx] = new Node(v, Math.max(0, v));
                return;
            }
            int mid = (l + r) >> 1;
            build(idx << 1, l, mid, arr);
            build(idx << 1 | 1, mid + 1, r, arr);
            tree[idx] = merge(tree[idx << 1], tree[idx << 1 | 1]);
        }

        Node merge(Node a, Node b) {
            long sum = a.sum + b.sum;
            long pref = Math.max(a.pref, a.sum + b.pref);
            return new Node(sum, pref);
        }

        void update(int pos, long val) {
            update(1, 0, n - 1, pos, val);
        }

        void update(int idx, int l, int r, int pos, long val) {
            if (l == r) {
                tree[idx] = new Node(val, Math.max(0, val));
                return;
            }
            int mid = (l + r) >> 1;
            if (pos <= mid)
                update(idx << 1, l, mid, pos, val);
            else
                update(idx << 1 | 1, mid + 1, r, pos, val);
            tree[idx] = merge(tree[idx << 1], tree[idx << 1 | 1]);
        }

        Node query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        Node query(int idx, int l, int r, int ql, int qr) {
            if (qr < l || r < ql)
                return new Node(0, 0); // neutral
            if (ql <= l && r <= qr)
                return tree[idx];
            int mid = (l + r) >> 1;
            return merge(
                    query(idx << 1, l, mid, ql, qr),
                    query(idx << 1 | 1, mid + 1, r, ql, qr)
            );
        }
    }

    // Fast Input
    static class FastScanner {
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            long sign = 1, res = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int q = fs.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextLong();

        SegTree st = new SegTree(arr);
        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            int type = fs.nextInt();
            if (type == 1) {
                int k = fs.nextInt() - 1;
                long u = fs.nextLong();
                st.update(k, u);
            } else {
                int a = fs.nextInt() - 1;
                int b = fs.nextInt() - 1;
                out.append(st.query(a, b).pref).append('\n');
            }
        }

        System.out.print(out);
    }
}
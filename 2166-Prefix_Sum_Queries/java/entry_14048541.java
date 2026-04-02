import java.io.*;
import java.util.*;



public class entry_14048541 {

    static class Node {
        long sum;   // sum of this segment
        long pref;  // max prefix sum of this segment
    }

    static class SegmentTree {
        int size;
        Node[] tree;

        SegmentTree(int n) {
            size = 1;
            while (size < n) size <<= 1;
            tree = new Node[2 * size];
            for (int i = 0; i < tree.length; i++) tree[i] = new Node();
        }

        void build(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                tree[size + i].sum = arr[i];
                tree[size + i].pref = Math.max(arr[i], 0);
            }
            for (int i = size - 1; i >= 1; i--) pull(i);
        }

        void pull(int x) {
            Node l = tree[2 * x], r = tree[2 * x + 1];
            tree[x].sum = l.sum + r.sum;
            tree[x].pref = Math.max(l.pref, l.sum + r.pref);
        }

        void update(int idx, int val) {
            int pos = size + idx;
            tree[pos].sum = val;
            tree[pos].pref = Math.max(val, 0);
            for (pos >>= 1; pos >= 1; pos >>= 1) pull(pos);
        }

        Node query(int l, int r) {
            Node leftRes = new Node(), rightRes = new Node();
            l += size; r += size;
            while (l < r) {
                if ((l & 1) == 1) leftRes = merge(leftRes, tree[l++]);
                if ((r & 1) == 1) rightRes = merge(tree[--r], rightRes);
                l >>= 1; r >>= 1;
            }
            return merge(leftRes, rightRes);
        }

        Node merge(Node a, Node b) {
            Node res = new Node();
            res.sum = a.sum + b.sum;
            res.pref = Math.max(a.pref, a.sum + b.pref);
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int q = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

        SegmentTree st = new SegmentTree(n);
        st.build(arr);

        while (q-- > 0) {
            int type = fs.nextInt();
            int a = fs.nextInt() - 1;
            int b = fs.nextInt();
            if (type == 1) {
                st.update(a, b); // set arr[a] = b
            } else {
                Node res = st.query(a, b);
                out.println(res.pref);
            }
        }
        out.flush();
    }

    // FastScanner for speed
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }
        int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = readByte();
            }
            return val * sign;
        }
    }
}

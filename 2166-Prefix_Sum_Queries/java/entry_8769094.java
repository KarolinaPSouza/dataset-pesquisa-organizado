import java.io.*;
import java.util.*;

public class entry_8769094 {
    private static StreamTokenizer in;
    private static StreamTokenizer in2;
    private static PrintWriter out;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static long nextInt2() throws IOException {
        in2.nextToken();
        return (long) in2.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    private static int mod = (int) 1e9 + 7;
    private static int PREFIX = 1;
    private static int SUFFIX = 2;
    private static int SUM = 3;
    private static int INNER = 4;

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new FileInputStream("src\\main\\resources\\test_input.txt"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
//        in2 = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_output.txt")));
        out = new PrintWriter(System.out);

        int n = nextInt();
        int t = nextInt();
        int size = 1;
        while (size < n) {
            size <<= 1;
        }

        long[][] tree = new long[2 * size - 1][5];
        for (int i = 0; i < n; i++) {
            tree[size - 1 + i][0] = nextInt();
            tree[size - 1 + i][PREFIX] = tree[size - 1 + i][0];
            tree[size - 1 + i][SUFFIX] = Math.max(0, tree[size - 1 + i][0]);
            tree[size - 1 + i][SUM] = tree[size - 1 + i][0];
            tree[size - 1 + i][INNER] = Math.max(0, tree[size - 1 + i][0]);
        }

        build(tree, 0, 0, size);

        for (int tt = 0; tt < t; tt++) {
            int k = nextInt();
            if (k == 2) {
                int l = nextInt() - 1;
                int r = nextInt() ;

                long[] res = get(tree, 0, l, r, 0, size);
                out.println(Math.max(0, res[PREFIX]));
            } else {
                int pos = nextInt() - 1;
                int val = nextInt();

                set(tree, val, pos, 0, 0, size);
            }

        }
        out.flush();
    }


    private static void build(long[][] tree, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            return;
        }

        int mid = (lx + rx) / 2;
        build(tree, 2 * idx + 1, lx, mid);
        build(tree, 2 * idx + 2, mid, rx);

        long[] left = tree[2 * idx + 1];
        long[] right = tree[2 * idx + 2];
        long[] res = tree[idx];

        res[PREFIX] = Math.max(left[PREFIX], left[SUM] + right[PREFIX]);
        res[SUFFIX] = Math.max(right[SUFFIX], left[SUFFIX] + right[SUM]);
        res[SUM] = left[SUM] + right[SUM];

        res[INNER] = Math.max(
                Math.max(left[INNER], right[INNER]),
                left[SUFFIX] + right[PREFIX]);
    }

    private static long get(long[] tree, int idx, int l, int r, int lx, int rx) {
        if (l >= rx || r <= lx) {
            return Integer.MAX_VALUE;
        }

        if (rx - lx == 1) {
            return tree[idx];
        }

        if (l <= lx && r >= rx) {
            return tree[idx];
        }

        int mid = (lx + rx) / 2;
        return Math.min(get(tree, 2 * idx + 1, l, r, lx, mid), get(tree, 2 * idx + 2, l, r, mid, rx));
    }

    private static long remove(long[][] tree, int idx, long pos, int lx, int rx) {
        if (rx - lx == 1) {
            tree[idx][1] = 0;
            return tree[idx][0];
        }

//        if (l <= lx && r >= rx) {
//            return tree[idx][];
//        }

        int mid = (lx + rx) / 2;
        long val;
        if (tree[2 * idx + 1][1] > pos) {
            val = remove(tree, 2 * idx + 1, pos, lx, mid);
        } else {
            val = remove(tree, 2 * idx + 2, pos - tree[2 * idx + 1][1], mid, rx);
        }
        tree[idx][1] = tree[2 * idx + 1][1] + tree[2 * idx + 2][1];
        return val;
    }

    private static long[] empty = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    private static long[] get(long[][] tree, int idx, int l, int r, int lx, int rx) {
        if (l >= rx || r <= lx) {
            return empty;
        }

        if (rx - lx == 1) {
            return tree[idx];
        }

        if (l <= lx && r >= rx) {
            return tree[idx];
        }

        int mid = (lx + rx) / 2;
        if (mid >= r) {
            return get(tree, 2 * idx + 1, l, r, lx, mid);
        }
        if (mid <= l) {
            return get(tree, 2 * idx + 2, l, r, mid, rx);
        }
        long[] left = get(tree, 2 * idx + 1, l, r, lx, mid);
        long[] right = get(tree, 2 * idx + 2, l, r, mid, rx);

        long[] res = new long[5];
        res[1] = Math.max(left[PREFIX], left[SUM] + right[PREFIX]);
        res[2] = Math.max(right[SUFFIX], left[SUFFIX] + right[SUM]);
        res[3] = left[SUM] + right[SUM];

        res[4] = Math.max(
                Math.max(left[INNER], right[INNER]),
                left[SUFFIX] + right[PREFIX]
        );

        return res;
    }

    private static void set(long[][] tree, int val, int l, int r, int idx, int lx, int rx) {
        if (r <= lx || l >= rx) {
            return;
        }

        if (rx - lx == 1) {
            tree[idx][0] += val;
            return;
        }

        if (l <= lx && rx <= r) {
            tree[idx][1] += val;
            return;
        }

        int m = (lx + rx) / 2;
        set(tree, val, l, r, 2 * idx + 1, lx, m);
        set(tree, val, l, r, 2 * idx + 2, m, rx);
    }

    private static void set(long[][] tree, int val, int pos, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            tree[idx][0] = val;
            tree[idx][1] = tree[idx][0];
            tree[idx][2] = Math.max(0, tree[idx][0]);
            tree[idx][3] = tree[idx][0];
            tree[idx][4] = Math.max(0, tree[idx][0]);

            return;
        }

        int m = (lx + rx) / 2;
        if (pos < m) {
            set(tree, val, pos, 2 * idx + 1, lx, m);
        } else {
            set(tree, val, pos, 2 * idx + 2, m, rx);
        }

        long[] left = tree[2 * idx + 1];
        long[] right = tree[2 * idx + 2];
        long[] res = tree[idx];

        res[PREFIX] = Math.max(left[PREFIX], left[SUM] + right[PREFIX]);
        res[SUFFIX] = Math.max(right[SUFFIX], left[SUFFIX] + right[SUM]);
        res[SUM] = left[SUM] + right[SUM];

        res[INNER] = Math.max(
                Math.max(left[INNER], right[INNER]),
                left[SUFFIX] + right[PREFIX]);
    }

    private static void set(long[] tree, int val, int pos, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            tree[idx] = val;
            return;
        }

        int m = (lx + rx) / 2;
        if (pos < m) {
            set(tree, val, pos, 2 * idx + 1, lx, m);
        } else {
            set(tree, val, pos, 2 * idx + 2, m, rx);
        }

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    private static void shuffle(int[] t) {
        int n = t.length;
        Random rand = new Random();
        int tmp, next;
        for (int i = 0; i < n / 4; i++) {
            next = rand.nextInt(n);
            tmp = t[i];
            t[i] = t[next];
            t[next] = tmp;
        }
    }
}

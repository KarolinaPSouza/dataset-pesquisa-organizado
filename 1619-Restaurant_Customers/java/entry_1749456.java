import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class Solution {
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

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new FileInputStream("src\\main\\resources\\test_input.txt"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
//        in2 = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_output.txt")));
        out = new PrintWriter(System.out);
//        long l = System.currentTimeMillis();
        int n = nextInt();

        int[] ins = new int[n];
        int[] outs = new int[n];
        for (int i = 0; i < n; i++) {
            ins[i] = nextInt();
            outs[i] = nextInt();
        }


        Arrays.sort(ins);
        Arrays.sort(outs);
        int max = 0;
        int r = 0;
        for (int l = 0; l <n; l++) {
            while (r < n && ins[r] < outs[l]) r++;
            max = Math.max(max, r - l );
        }
        out.println(max);
        out.flush();
    }

    private static void shuffle(int[][] t) {
        int n = t.length;
        Random rand = new Random();
        int tmp, tmp2, next;
        for (int i = 0; i < n / 4; i++) {
            next = rand.nextInt(n);
            tmp = t[i][0];
            tmp2 = t[i][1];
            t[i][0] = t[next][0];
            t[i][1] = t[next][1];
            t[next][0] = tmp;
            t[next][1] = tmp2;
        }
    }

    private static int get(int[] tree, int size, int price) {
        return get(tree, price, 0, 0, size);
    }

    private static int get(int[] tree, int price, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            int res = tree[idx];
            tree[idx] = Integer.MAX_VALUE;
            return res;
        }

        if (tree[idx] > price) return -1;

        int m = (lx + rx) / 2;
        int res;
        if (price < tree[2 * idx + 2]) {
            res = get(tree, price, 2 * idx + 1, lx, m);
        } else {
            res = get(tree, price, 2 * idx + 2, m, rx);
        }

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
        return res;
    }

    private static void set(int[] tree, int val, int pos, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            tree[idx] = val;
            return;
        }

        int m = (lx + rx) / 2;
        if (pos < m) {
            set(tree, val, pos, 2 * idx + 1, lx, m);
            tree[idx] = tree[2 * idx + 1];
        } else {
            set(tree, val, pos, 2 * idx + 2, m, rx);
            tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
        }
    }

}

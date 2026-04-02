import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class entry_7901740 {

    static void solve(FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = in.nextIntArray(n);
        ArrayList<Integer> indexes = toList(a);
        indexes.sort(Comparator.comparingInt(i -> a[i]));
        for (int i = 0; i < n; i++) {
            int search = x - a[indexes.get(i)];
            int upperBound = upperBound(a, indexes, search);
            if (upperBound > 0 && a[indexes.get(upperBound - 1)] == search && i != upperBound - 1) {
                out.println((indexes.get(i) + 1) + " " + (indexes.get(upperBound - 1) + 1));
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    static int upperBound(int[] a, ArrayList<Integer> indexes, int x) {
        int l = -1;
        int r = a.length;
        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            if (a[indexes.get(mid)] <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void sort(int[] a) {
        ArrayList<Integer> arrayList = toList(a);
        Collections.sort(arrayList);
        for (int i = 0; i < a.length; i++) {
            a[i] = arrayList.get(i);
        }
    }

    static ArrayList<Integer> toList(int[] a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }
}
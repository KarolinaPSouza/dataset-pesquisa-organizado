import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Arrays.setAll;
import static java.util.Arrays.stream;

public class entry_4742902 {
    private static final FastScanner scanner = new FastScanner();

    private static void solve() {
        int x = i(), y = i();
        long mx = max(x, y);
        long row = 1, column = 1;
        if (mx%2 == 0) {
            row = mx*mx;
            column = (mx-1)*(mx-1)+1;
        } else {
            column = mx*mx;
            row = (mx-1)*(mx-1)+1;
        }
        if (y>x) {
            if (y%2 == 0) {
                out.println(column+x-1);
            } else {
                out.println(column-(x-1));
            }
        } else {
            if (x%2 == 0) {
                out.println(row-(y-1));
            } else {
                out.println(row+y-1);
            }
        }
    }

    public static void main(String[] args) {
        int t = i();
        while (t-->0) {
            solve();
        }
    }

    private static long l() {
        return scanner.nextLong();
    }

    private static int i() {
        return scanner.nextInt();
    }

    private static String s() {
        return scanner.next();
    }

    private static void printArray(long[] a) {
        StringBuilder builder = new StringBuilder();
        for (long i : a)
            builder.append(i).append(' ');
        out.println(builder);
    }

    private static void printArray(int[] a) {
        StringBuilder builder = new StringBuilder();
        for (int i : a)
            builder.append(i).append(' ');
        out.println(builder);
    }

    private static int binPow(int a, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return binPow(a, n-1) * a;
        else {
            int b = binPow(a, n/2);
            return b * b;
        }
    }
//
//    private static void stableSort(int[] a) {
//        List<Integer> list = stream(a).boxed().sorted().toList();
//        setAll(a, list::get);
//    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i<n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class SegmentTreeRMXQ {
        static int getMid(int s, int e) {
            return s + (e - s) / 2;
        }
        static int MaxUtil(int[] st, int ss, int se, int l, int r, int node) {
            if (l <= ss && r >= se)
                return st[node];
            if (se < l || ss > r)
                return -1;
            int mid = getMid(ss, se);

            return Math.max(
                    MaxUtil(st, ss, mid, l, r,
                            2 * node + 1),
                    MaxUtil(st, mid + 1, se, l, r,
                            2 * node + 2));
        }
        static void updateValue(int[] arr, int[] st, int ss, int se, int index, int value, int node) {
            if (index < ss || index > se) {
                System.out.println("Invalid Input");
                return;
            }
            if (ss == se) {
                arr[index] = value;
                st[node] = value;
            } else {
                int mid = getMid(ss, se);

                if (index <= mid)
                    updateValue(arr, st, ss, mid,
                            index, value,
                            2 * node + 1);
                else
                    updateValue(arr, st, mid + 1, se, index,
                            value, 2 * node + 2);

                st[node] = Math.max(st[2 * node + 1],
                        st[2 * node + 2]);
            }
        }
        static int getMax(int[] st, int n, int l, int r) {
            if (l < 0 || r > n - 1 || l > r) {
                System.out.print("Invalid Input\n");
                return -1;
            }

            return MaxUtil(st, 0, n - 1, l, r, 0);
        }
        static int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }
            int mid = getMid(ss, se);

            st[si] = Math.max(
                    constructSTUtil(arr, ss, mid,
                            st, si * 2 + 1),
                    constructSTUtil(arr, mid + 1,
                            se, st,
                            si * 2 + 2));

            return st[si];
        }
        static int[] constructST(int[] arr, int n) {
            int x = (int)Math.ceil(Math.log(n) / Math.log(2));
            int max_size = 2 * (int)Math.pow(2, x) - 1;
            int[] st = new int[max_size];
            constructSTUtil(arr, 0, n - 1, st, 0);
            return st;
        }
    }

    static class SegmentTreeRSQ {
        int[] st;
        SegmentTreeRSQ(int[] arr, int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            st = new int[max_size];
            constructSTUtil(arr, 0, n - 1, 0);
        }
        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }
        int getSumUtil(int ss, int se, int qs, int qe, int si) {
            if (qs <= ss && qe >= se)
                return st[si];
            if (se < qs || ss > qe)
                return 0;
            int mid = getMid(ss, se);
            return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                    getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
        }
        void updateValueUtil(int ss, int se, int i, int diff, int si) {
            if (i < ss || i > se)
                return;
            st[si] = st[si] + diff;
            if (se != ss) {
                int mid = getMid(ss, se);
                updateValueUtil(ss, mid, i, diff, 2 * si + 1);
                updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
            }
        }
        void updateValue(int[] arr, int n, int i, int new_val) {
            if (i < 0 || i > n - 1) {
                System.out.println("Invalid Input");
                return;
            }
            int diff = new_val - arr[i];
            arr[i] = new_val;
            updateValueUtil(0, n - 1, i, diff, 0);
        }
        int getSum(int n, int qs, int qe) {
            if (qs < 0 || qe > n - 1 || qs > qe) {
                System.out.println("Invalid Input");
                return -1;
            }
            return getSumUtil(0, n - 1, qs, qe, 0);
        }
        int constructSTUtil(int[] arr, int ss, int se, int si) {
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }
            int mid = getMid(ss, se);
            st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2);
            return st[si];
        }
    }

    static class SegmentTreeRMQ {
        int[] st;

        int minVal(int x, int y) {
            return Math.min(x, y);
        }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }
        int RMQUtil(int ss, int se, int qs, int qe, int index) {
            if (qs <= ss && qe >= se)
                return st[index];
            if (se < qs || ss > qe)
                return Integer.MAX_VALUE;
            int mid = getMid(ss, se);
            return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                    RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
        }

        int RMQ(int n, int qs, int qe) {
            if (qs < 0 || qe > n - 1 || qs > qe) {
                System.out.println("Invalid Input");
                return -1;
            }

            return RMQUtil(0, n - 1, qs, qe, 0);
        }

        int constructSTUtil(int[] arr, int ss, int se, int si) {
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }
            int mid = getMid(ss, se);
            st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2));
            return st[si];
        }

        void constructST(int[] arr, int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            st = new int[max_size]; // allocate memory
            constructSTUtil(arr, 0, n - 1, 0);
        }
    }
}
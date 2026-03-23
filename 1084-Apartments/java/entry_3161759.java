import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_3161759 {
    public static void solve() {
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();

        int[] pop = new int[n];
        for (int i = 0; i < n; i++) {
            pop[i] = io.nextInt();
        }
        int[] rooms = new int[m];
        for (int i = 0; i < m; i++) {
            rooms[i] = io.nextInt();
        }
        sortIntArray(pop);
        sortIntArray(rooms);
//        System.out.println(Arrays.toString(pop));
//        System.out.println(Arrays.toString(rooms));

        int L = 0;
        int ans = 0;
        for (int room : rooms) {
            int person = bSearch(pop, L, pop.length - 1, room - k, room + k);
//            System.out.println(person);

            if (person > -1) {
                ans++;
                L = person + 1;
            }
        }

        System.out.println(ans);
    }

    public static int bSearch(int[] arr, int L, int R, int targetL, int targetR) {
        int ans = -1;

        while (L <= R) {
            int mid = L + (R - L) / 2;
            int size = arr[mid];

            if (size >= targetL && size <= targetR) {
                ans = mid;
                R = mid - 1;
            } else if (size < targetL) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return ans;
    }

    public static void sortIntArray(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : arr) al.add(i);
        Collections.sort(al);
        for (int i = 0; i < arr.length; i++) arr[i] = al.get(i);
    }

    static boolean testCasesIn = false;

    // region CP-BOILERPLATE
    // CP BOILERPLATE TEMPLATE
    public static void main(String[] args) throws IOException {
        int testCases = 1;
        if (testCasesIn) testCases = io.nextInt();
        for (int t = 0; t < testCases; t++) solve();
        io.close();
    }

    static FastIO io = new FastIO();

    static class FastIO extends PrintWriter {
        private BufferedReader br;
        private StringTokenizer st;

        public FastIO() {
            super(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            super.close();
        }
    }
    //endregion
}
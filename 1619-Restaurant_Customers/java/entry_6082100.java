/**
 * date: 5/17/2023
 */

import java.io.*;
import java.util.*;

public class entry_6082100 {

    public static void solve() {
        int N = sc.nextInt();
        Map<Integer, Integer> record = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int arrive = sc.nextInt();
            int leave = sc.nextInt();

            record.put(arrive, 1);
            record.put(leave, -1);
        }

        int ans = 0;
        int people = 0;
        for (int time : record.keySet()) {
            people += record.get(time);
            ans = Math.max(ans, people);
        }

        pw.println(ans);
    }


    // region CP-BOILERPLATE
    // CP BOILERPLATE TEMPLATE

    public static long nCk(long n, long k) {
        double sum = 1;
        for (int i = 1; i <= k; i++) {
            sum = sum * (n - k + i) / i;
        }
        return (long) sum;
    }

    static InputReader sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        sc = new InputReader();
        pw = new PrintWriter(System.out);

//        sc = new InputReader("input.in");
//        pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));

        solve();
        pw.close();
    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public InputReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
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
    }


    /*
    Ruffle Sort - shuffle array before sorting
    Arrays.sort in java uses quicksort for primitive data types
    Quicksort has runtime O(nlogn), but has worst case runtime of O(n^2) for arrays that are almost sorted
    Shuffling array before sorting helps to avoid worst case runtime
     */

    public static void sortIntArray(int[] arr) {
        int n = arr.length;
        Random random = new Random();

        // shuffle, then sort
        for (int i = 0; i < n; i++) {
            int temp = arr[i]; // change for each data type
            int randomIndex = random.nextInt(n);
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }

        Arrays.sort(arr);
    }

    //endregion
}
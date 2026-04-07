import java.io.*;
import java.util.*;

public class entry_11181280 {
    static FastReader sc = new FastReader();

    static void helper() {
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            map.put(val, map.getOrDefault(val, 0));
        }

        System.out.println(map.size());
    }


    public static void main(String[] args) {
        // int test = sc.nextInt();
        // while(test-- > 0) {
        //     helper();
        // }
        helper();
    }

    @SuppressWarnings("unused")
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        @SuppressWarnings("CallToPrintStackTrace")
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        @SuppressWarnings("CallToPrintStackTrace")
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

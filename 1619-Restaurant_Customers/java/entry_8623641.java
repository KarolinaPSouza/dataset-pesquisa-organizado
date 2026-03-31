import java.io.*;
import java.util.*;


public class entry_8623641 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve(sc, out);

        out.flush();
        out.close();
    }

    private static void solve(MyScanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int[] ins = new int[n];
        int[] outs = new int[n];
        for (int i = 0; i < n; i++) {
            ins[i] = sc.nextInt();
            outs[i] = sc.nextInt();
        }

        Arrays.sort(ins);
        Arrays.sort(outs);

        int size = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (l < n) {
            while (l < n && ins[l] < outs[r]) {
                size++;
                l++;
            }
            max = Math.max(size, max);
            while (l < n && outs[r] < ins[l]) {
                size--;
                r++;
            }
        }

        out.println(max);
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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
    //--------------------------------------------------------
}
import java.io.*;
import java.util.*;


public class entry_8623490 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve(sc, out);

        out.flush();
        out.close();
    }

    private static void solve(MyScanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int size = 1;
        while (size < n) size <<= 1;
        int[] tickets = new int[2 * size - 1];


        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();
        }

        int tmp;
        for (int i = 0; i < n / 10; i++) {
            tmp = tickets[i];
            tickets[i] = tickets[n - 1 - i];
            tickets[n - 1 - i] = tmp;
        }
        Arrays.sort(tickets);

        build(tickets, 0, 0, size);

        for (int i = 0; i < m; i++) {
            int v = get(tickets, sc.nextInt(), 0, 0, size);
            if (v <= 0) out.println(-1);
            else out.println(v);
        }
    }

    private static int get(int[] tickets, int val, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            int v = tickets[idx];
            tickets[idx] = Integer.MAX_VALUE;
            return v == Integer.MAX_VALUE ? -1 : v;
        }

        if (tickets[idx] > val) {
            return -1;
        }

        int mid = (lx + rx) / 2;
        int res;
        if (val < tickets[2 * idx + 2]) {
            res = get(tickets, val, 2 * idx + 1, lx, mid);
        } else {
            res = get(tickets, val, 2 * idx + 2, mid, rx);
        }

        tickets[idx] = Math.min(tickets[2 * idx + 1], tickets[2 * idx + 2]);
        return res;
    }

    private static void build(int[] tickets, int idx, int lx, int rx) {
        if (rx - lx == 1) {
            return;
        }

        int mid = (lx + rx) / 2;
        build(tickets, 2 * idx + 1, lx, mid);
        build(tickets, 2 * idx + 2, mid, rx);

        tickets[idx] = Math.min(tickets[2 * idx + 1], tickets[2 * idx + 2]);
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
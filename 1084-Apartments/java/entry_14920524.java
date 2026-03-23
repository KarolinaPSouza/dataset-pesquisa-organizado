import java.io.*;
import java.util.*;

public class entry_14920524 {

    // Entrada rápida
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { e.printStackTrace(); return null; }
        }

        boolean hasNext() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private static <T> ArrayList<ArrayList<T>> vvt(int n, int m, T value) {
        ArrayList<ArrayList<T>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<T> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(value);
            }
            res.add(row);
        }
        return res;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> desiredSize = new ArrayList<>();
        for (int i=0; i<n; i++) {
            desiredSize.add(in.nextInt());
        }

        ArrayList<Integer> apSize = new ArrayList<>();
        for (int i=0; i<m; i++) {
            apSize.add(in.nextInt());
        }

        Collections.sort(desiredSize);
        Collections.sort(apSize);

        int d = 0;
        int a = 0;
        int res = 0;
        while (d<n && a<m) {
            while (d<n && a<m && apSize.get(a)<desiredSize.get(d)-k) a++;
            while (d<n && a<m && apSize.get(a)>desiredSize.get(d)+k) d++;
            if (d<n && a<m && desiredSize.get(d)-k<=apSize.get(a) && apSize.get(a)<=desiredSize.get(d)+k) {
                a++;
                d++;
                res++;
            }
        }

        out.println(res);





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}
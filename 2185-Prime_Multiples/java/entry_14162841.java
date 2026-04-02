import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class entry_14162841 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try { str = br.readLine().trim(); } catch (Exception e) { e.printStackTrace(); }
            return str;
        }

        int[] readIntArr(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        long[] readLongArr(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }

        double[] readDoubleArr(int n) {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) arr[i] = nextDouble();
            return arr;
        }

        String[] readStringArr(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = next();
            return arr;
        }

        int[][] readInt2DArr(int r, int c) {
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    arr[i][j] = nextInt();
            return arr;
        }

        long[][] readLong2DArr(int r, int c) {
            long[][] arr = new long[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    arr[i][j] = nextLong();
            return arr;
        }

        double[][] readDouble2DArr(int r, int c) {
            double[][] arr = new double[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    arr[i][j] = nextDouble();
            return arr;
        }

        String[][] readString2DArr(int r, int c) {
            String[][] arr = new String[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    arr[i][j] = next();
            return arr;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void println(Object... objects) throws IOException {
            for (int i = 0; i < objects.length; i++) {
                if (i > 0) bw.append(" ");
                bw.append(String.valueOf(objects[i]));
            }
            bw.append("\n");
        }

        public void printarr(Object[] array) throws IOException {
            for (int i = 0; i < array.length; i++) {
                if (i > 0) bw.append(" ");
                bw.append(String.valueOf(array[i]));
            }
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        FastWriter out = new FastWriter();
        long n = sc.nextLong();
        int k = sc.nextInt();
        long[] p = sc.readLongArr(k);
        long ans = 0;
        for(long i = 1;i<(1<<k);i++)
        {
            long count = 0;
            long prod = 1;
            for(int j = 0;j<=k;j++)
            {
                if(((i>>j)&1) == 1)
                {
                    count++;
                    if(prod <= n / p[j]) prod *= p[j];
                    else prod = n + 1;
                }
            }
            if(count % 2 == 0)
            {
                ans -= n / prod;
            }
            else ans += n / prod;
        }

        out.println(ans);

        out.close();
    }
}
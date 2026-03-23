import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;


public class entry_4709652 {

   static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t != 0) {


            long row = sc.nextLong();
            long col = sc.nextLong();


            boolean maxIsRow = false;
            boolean maxIsCol = false;
            long max;
            if (row > col) {
                maxIsRow = true;
                max = row;
            } else {
                maxIsCol = true;
                max = col;
            }

            long ans = 0;

            long start = (max-1)*(max-1) + 1;
            long end = max * max;

            if (maxIsRow) {
                if (max % 2 == 1) {
                    ans = (start + col - 1);
                } else {
                    ans =  (end - col + 1);
                }
            }

            if (maxIsCol) {
                if (max % 2 == 1) {

                    ans = (end - row + 1);

                } else {
                    ans = (start + row - 1);

                }
            }
            System.out.println(ans);
            t--;
        }
    }

}


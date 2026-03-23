import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_2919420 {
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

 public static void main(String[] args)
    {
        FastReader s = new FastReader();
        int n = s.nextInt();
        while (n-- > 0) {
            String[] pos = s.nextLine().split(" ");
            long row=Long.parseLong(pos[0]);
   long col=Long.parseLong(pos[1]);
   long result=0;
   if (col>row) {
    long h=col*col;
    long l=h-(col*2 - 2);
    if (col%2==0) {
     result=(l+row) - 1;
    } else {
     result=(h-row) + 1;
    }
   } else if (row>col) {
    long h=row*row;
    long l=h-(row*2 - 2);
    if (row%2==0) {
     result=(h-col) + 1;
    } else {
     result=(l+col) - 1;
    }
   } else {
    result = row*col - (row - 1);
   }

   System.out.println(result);
        }
    }
}
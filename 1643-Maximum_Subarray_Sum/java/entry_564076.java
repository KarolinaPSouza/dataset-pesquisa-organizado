import java.io.*;
import java.util.*;

public class entry_564076 {
 public static void main(String args[]) {
  FastScanner in = new FastScanner();
  int n = in.nextInt();

  long max = 0;
  long m = 0;
  boolean pos = false;
  long[] arr = new long[n];
  for (int i = 0; i < n; i++) {
   m += arr[i] = in.nextLong();
   if (arr[i] >= 0) pos = true;
   if (m < 0)
    m = 0;
   if (m > max)
    max = m;
  }

  if (!pos) {
   long small = Integer.MIN_VALUE;
   for (int i = 0; i < n; i++) {
    small = Math.max(small, arr[i]);
   }

   System.out.println(small);
   return;
  }

  System.out.println(max);
 }

    public static void shuffle(int[] arr) {
     Random rgen = new Random();

     for (int i = 0; i < arr.length; i++) {
      int rPos = rgen.nextInt(arr.length);
      int temp = arr[i];
      arr[i] = arr[rPos];
      arr[rPos]=temp;
     }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
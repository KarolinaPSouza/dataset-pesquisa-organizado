 import java.io.*;
 import java.util.*;
 public class entry_13009030 {
     static class FastReader {
     BufferedReader b;
     StringTokenizer s; 
     public FastReader() {
     b = new BufferedReader
     (new InputStreamReader(System.in));
     }
     String next() {
     while (s == null || !s.hasMoreElements()) {
     try {
         s = new StringTokenizer(b.readLine());
     } catch (IOException e) {
         e.printStackTrace(); 
     }
     }
     return s.nextToken();
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
         if (s.hasMoreTokens()) {
             str = s.nextToken("\n");
         } else {
             str = b.readLine();
         }
     } catch (IOException e) {
         e.printStackTrace(); 
     }
     return str;
     }
 }
     // Predefined variables
     static FastReader sc = new FastReader();
     static HashMap<Integer, Integer> map = new HashMap<>();
     static TreeMap<Character,Integer> mp = new TreeMap<>();
     static int n, m, a, b, c, d, cnt, t, num, temp;
     static String s, str, res, rev;
     static long dd, val, sum;
     // Main Method
     public static void main(String args[]) throws IOException {
        int m = sc.nextInt();
        int[][] arr = { {1,  2,  9,  10, 25   },
                        {4,  3,  8,  11, 24   },
                        {5,  6,  7,  12, 23   },
                        {16, 15, 14, 13, 22   },
                        {17, 18, 19, 20, 21   }};
        while(m-->0)
            numberSpiral(sc.nextInt(), sc.nextInt());
     }
     static void numberSpiral(long Y, long X) 
     {
        if (Y > X) {
            long ans = (Y - 1) * (Y - 1);
            long add;
            if (Y % 2 != 0)
                add = X;
            else 
                add = 2 * Y - X;
            System.out.println(ans + add);
        }
        else {
            long ans = (X - 1) * (X - 1);
            long add;
            if (X % 2 == 0) 
                add = Y;
            else 
                add = 2 * X - Y;
            System.out.println(ans + add);
        }
    }

 }
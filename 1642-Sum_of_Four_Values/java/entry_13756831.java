import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class entry_13756831 {

   static int mod = (int)(1e9 + 7);
   static boolean MULTI_CASE = false;
   // static Integer dp[][]; 

   public static void solve() throws IOException {
        int n = sc.nextInt();
        long x = sc.nextLong();
        long arr[] = new long[n];
        HashMap<Long, int[]> set = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
               long req = x - arr[i] - arr[j];
               if(set.containsKey(req)) {
                  out.println(set.get(req)[0]+" "+set.get(req)[1]+" "+(i + 1)+" "+(j + 1));
                  return;
               }
            }
            for(int j = 0; j < i; j++) {
               set.put(arr[i] + arr[j], new int[]{j + 1, i + 1});
            }
        }

        out.println("IMPOSSIBLE");
   }

   public static void main(String[] args) throws IOException {
      if (MULTI_CASE) {
         int T = sc.nextInt();
         for (int i = 0; i < T; ++i) {
            solve();
         }
      } 
      else {
         solve();
      }
      out.close();
   }

   static InputReader sc = new InputReader();
   static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

   static class InputReader {
      private StringTokenizer st;
      private BufferedReader bf;

      public InputReader() {
         bf = new BufferedReader(new InputStreamReader(System.in));
         st = null;
      }

      public String next() throws IOException {
         while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
         }
         return st.nextToken();
      }

      public String nextLine() throws IOException {
         return bf.readLine();
      }

      public int nextInt() throws IOException {
         return Integer.parseInt(next());
      }

      public long nextLong() throws IOException {
         return Long.parseLong(next());
      }

      public double nextDouble() throws IOException {
         return Double.parseDouble(next());
      }
   }
}
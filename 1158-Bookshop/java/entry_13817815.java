import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class entry_13817815 {

 public static void main(String[] args) throws Exception {
  FastReader sc = new FastReader();
  // PrintWriter out = new PrintWriter(new File("paintbarn.out"));
  int n = sc.nextInt();
  int x = sc.nextInt();
  int[] price = new int[n];
  for(int i = 0; i < n; ++i) price[i] = sc.nextInt();
  int[] pages = new int[n];
  for(int i = 0; i < n; ++i) pages[i] = sc.nextInt();
  int[] dp = new int[x+1];
  for(int i = 0; i < n; ++i) {
   int[] newDp = new int[x+1];
   for(int j = 1; j <= x; ++j) {
    newDp[j] = Math.max(dp[j], newDp[j-1]);
    if(price[i] <= j) {
     newDp[j] = Math.max(newDp[j], dp[j - price[i]] + pages[i]);
    }
   }
   dp = newDp;
  }
  out.println(dp[x]);
  out.close();
 }

 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  FastReader() throws Exception{
   br = new BufferedReader(new InputStreamReader(System.in));
   // br = new BufferedReader(new FileReader("paintbarn.in"));
  }

  String next() {
   if(st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch(IOException e) {
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

  Double nextDouble() {
   return Double.parseDouble(next());
  }

  String nextLine() {
   String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
  }
 }
}
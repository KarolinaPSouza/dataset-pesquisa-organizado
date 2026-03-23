import java.io.*;
import java.util.*;

public class entry_2402155 {
 static class Reader {
  BufferedReader br;
  StringTokenizer st;

  public Reader() { br = new BufferedReader(new InputStreamReader(System.in)); }

  String next() {
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

  double nextDouble() { return Double.parseDouble(next()); }

  String nextLine() {
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
  var in = new Reader();
        var t = in.nextInt();
        long i, j, layer, ans;
        while (t-- > 0) {
            i = in.nextInt();
            j = in.nextInt();
            layer = Math.max(i, j);
            if (layer % 2 == 0) {
                if (layer == i) {
                    ans = layer * layer - j + 1;
                } else {
                    ans = (layer - 1) * (layer - 1) + i;
                }
            } else {
                if (layer == j) {
                    ans = layer * layer - i + 1;
                } else {
                    ans = (layer - 1) * (layer - 1) + j;
                }
            }
            System.out.println(ans);
        }
    }
}

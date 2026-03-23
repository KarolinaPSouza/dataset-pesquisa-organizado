import java.io.*;
import java.util.*;

public class entry_16003278 {

  public static void main(String[] args) throws IOException {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);

    // Your logic here
    int n = fs.nextInt();
    int m = fs.nextInt();
    int k = fs.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = fs.nextInt();
    }
    Arrays.sort(arr);
    int siz[] = new int[m];
    for (int i = 0; i < m; i++) {
      siz[i] = fs.nextInt();
    }
    Arrays.sort(siz);
    int ans = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      boolean flag = false;
      while (j < m && arr[i] > siz[j]) {
        if (arr[i] - siz[j] <= k) {
          ans++;
          j++;
          flag = true;
          break;
        }
        j++;
      }
      if (flag)
        continue;
      if (j < m && siz[j] - arr[i] <= k) {
        ans++;
        j++;
      }
    }
    out.println(ans);
    out.flush();
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (st == null || !st.hasMoreTokens()) {
        st = new StringTokenizer(br.readLine());
      }
      return st.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }
}
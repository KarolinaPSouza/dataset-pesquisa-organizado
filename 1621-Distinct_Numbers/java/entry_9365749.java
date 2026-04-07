import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class entry_9365749 {
  static PrintWriter pw ;
  static Reader fs ;

  public static void solve() throws IOException {
    int n = fs.nextInt();
    int a[] = fs.readArray(n);
    HashSet<Integer> s = new HashSet<>();
    for(int x : a) s.add(x);
    pw.println(s.size());
  }

  public static void main(String[] args) throws Exception {
    // pw = new PrintWriter("balancing.out");
    // fs = new Reader("balancing.in");
    pw = new PrintWriter(System.out);
    fs = new Reader();
    solve();
    pw.close();
  }

  public static void sort(int a[]) {
    ArrayList<Integer> l = new ArrayList<>();
    for(int x : a) l.add(x);

    Collections.sort(l);

    for(int i = 0 ; i < a.length ; i++) {
      a[i] = l.get(i);
    }
  }

  static class Reader {
    private BufferedReader br;
    private StringTokenizer st;

    public Reader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
      this.st = new StringTokenizer("");
    }

    public Reader(String inFile) throws Exception {
      this.br = new BufferedReader(new FileReader(inFile));
      this.st = new StringTokenizer("");
    }

    public int nextInt() throws IOException {
      if(!this.st.hasMoreTokens()) this.fillBuffer();
      return Integer.parseInt(this.st.nextToken());
    }

    public long nextLong() throws IOException {
      if(!this.st.hasMoreTokens()) this.fillBuffer();
      return Long.parseLong(this.st.nextToken());
    }

    public String next() throws IOException {
      if(!this.st.hasMoreTokens()) this.fillBuffer();
      return st.nextToken();
    }

    public int[] readArray(int n) throws IOException {
      if(this.st.hasMoreTokens()) this.fillBuffer();
      int a[] = new int[n];
      for(int i = 0 ; i < n ; i++) a[i] = this.nextInt();
      return a;
    }

    private void fillBuffer() throws IOException {
      st = new StringTokenizer(br.readLine());
    }
  }
}
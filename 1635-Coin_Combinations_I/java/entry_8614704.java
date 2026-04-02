import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class entry_8614704 {

  static Reader in = new Reader();
  static StringBuilder output=new StringBuilder();
  static class Reader{
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public Reader() {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
    }
    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }
  }

//  private static long power(int a, int b , int mod) {
//    if (b > 1) {
//      long pw = power(a, b / 2, mod);
//      pw = (pw * pw) % mod;
//      if((b&1) == 1) {
//        pw = (a * pw) % mod;
//      }
//      return pw;
//    }
//    return a;
//  }

  public static int binarySearch(int[] a, int l, int r, int value) {
    if(l>r || l==a.length) return l;
    int mid=(r+l)/2;
    if(a[mid]>value) {
      if(l<=mid-1) return binarySearch(a, l, mid-1, value);
      return l;
    }
    else {
      if(mid+1<=r) return binarySearch(a, mid+1, r, value);
      return mid+1;
    }
  }

  static void sort(int[] a) {
    ArrayList<Integer> l = new ArrayList<>();
    for (int i : a)
      l.add(i);
    Collections.sort(l);
    for (int i = 0; i < a.length; i++)
      a[i] = l.get(i);
  }



  public static void main(String[] args) {
    int n = Integer.parseInt(in.next());
    int x = Integer.parseInt(in.next());
    int[] dp = new int[1000001];
    int[] a=new int[n];
    for(int i=0;i<n;i++) {
      a[i]=Integer.parseInt(in.next());
    }
    dp[0]=1;
    for(int i=1;i<=x;i++) {
      for(int j=0;j<n;j++) {
        if(i>=a[j]) dp[i]=(dp[i]+dp[i-a[j]])%1000000007;
      }
    }
    System.out.println(dp[x]);
  }
}
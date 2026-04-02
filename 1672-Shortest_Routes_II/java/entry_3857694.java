import java.util.*;
import java.io.*;

public class entry_3857694 {
 static long[][] a;
 static int n, m, q;
 static BufferedReader in;
 static StringBuilder sss = new StringBuilder();
 public static void main(String[] args) throws Exception {
  in = new BufferedReader(new InputStreamReader(System.in));

  init();
  for(int i = 0; i < q; i ++) 
  solve();
  System.out.println(sss.toString());

 }

 public static void init() throws Exception {
  StringTokenizer str= new StringTokenizer(in.readLine());

  n = Integer.parseInt(str.nextToken());
  m = Integer.parseInt(str.nextToken());
  q = Integer.parseInt(str.nextToken());

  a = new long[n][n];

  for(int i1 = 0; i1 < n; i1 ++) {
   for(int i2 = 0; i2 < n; i2 ++) {
    if(i1==i2)
     continue;
    a[i1][i2] = Long.MAX_VALUE / 2;
   }
  }

  for(int i = 0; i < m; i ++) {
   str = new StringTokenizer(in.readLine());
   int start = Integer.parseInt(str.nextToken()) - 1;
   int end = Integer.parseInt(str.nextToken()) - 1;
   long distance =Integer.parseInt(str.nextToken());
   if(a[start][end] > distance) {
   a[start][end] = distance;
   a[end][start] = distance;
   }

  }

  for(int mid = 0; mid < n; mid ++) {
   for(int start = 0; start < n; start ++) {
    for(int end = 0; end < n; end ++) {
     if(a[start][mid] + a[mid][end] < a[start][end])
      a[start][end] = a[start][mid] + a[mid][end];
    }
   }
  }
//  for(long[] i: a)
//   System.out.println(Arrays.toString(i));

 }

 public static void solve () throws Exception {
  StringTokenizer str = new StringTokenizer(in.readLine());

  int first = Integer.parseInt(str.nextToken()) - 1;
  int last = Integer.parseInt(str.nextToken()) - 1;
//  StringBuilder sss = new StringBuilder();
  if(a[first][last] == Long.MAX_VALUE / 2)
   sss.append("-1\n");
  else {
   sss.append((a[first][last]));
   sss.append("\n");
  }

 }

}
//package CSES;

import java.io.*;
import java.util.*;

public class entry_3331455 {


 static MyScanner sc = new MyScanner();
 static PrintWriter pw = new PrintWriter(System.out);
 public static void main(String[] args) {
  // TODO Auto-generated method stub

  int n = sc.nextInt();
  TreeSet<Integer> ts = new TreeSet<>();
  for(int i = 0; i<n; i++) {
   ts.add(sc.nextInt());
  }

  pw.println(ts.size());
  pw.close();
 }

  public static class MyScanner {
         BufferedReader br;
         StringTokenizer st;

         public MyScanner() {
             br = new BufferedReader(new InputStreamReader(System.in));
         }

         String next() {
             while (st == null || !st.hasMoreElements()) {
                 try {
                     st = new StringTokenizer(br.readLine());
                 } catch (IOException e) {
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

         double nextDouble() {
             return Double.parseDouble(next());
         }

         String nextLine() {
             String str = "";
             try {
                 str = br.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return str;
         }

     }

}
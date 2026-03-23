//package lodu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_4643201 {
 static class FastReader {
      BufferedReader br;
      StringTokenizer st;

      public FastReader()
      {
          br = new BufferedReader(
              new InputStreamReader(System.in));
      }

      String next()
      {
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

      double nextDouble()
      {
          return Double.parseDouble(next());
      }

      String nextLine()
      {
          String str = "";
          try {
              if(st.hasMoreTokens()){
                  str = st.nextToken("\n");
              }
              else{
                  str = br.readLine();
              }
          }
          catch (IOException e) {
              e.printStackTrace();
          }
          return str;
      }
   /*public static Long gcd(Long a,Long b) {
   if (b == 0)   
   return a;     
   return gcd(b, a % b);   
 }*/
  }
 public static void main(String[] args) {
  FastReader sc=new FastReader();
  PrintWriter o=new PrintWriter(System.out);
  int t=sc.nextInt();
  while(t-->0) {
   Long x,y;
   x=sc.nextLong();
   y=sc.nextLong();
   if(x==y) {
    o.print(x*x-(y-1)+"\n");
   }
   else if(x>y) {
    Long ans=x*x-(x-1);
    if(x%2==0) {
     ans+=(x-y);
    }
    else {
     ans-=(x-y);
    }
    o.print(ans+"\n");
   }
   else {
    Long result=y*y-(y-1);
    if(y%2==0)
     result-=(y-x);
    else
     result+=(y-x);
    o.print(result+"\n");
   }
  }
  o.close();
 }
}
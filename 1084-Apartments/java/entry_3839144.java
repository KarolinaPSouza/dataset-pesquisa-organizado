//package pratice;

import java.io.*;
import java.util.*;

public class entry_3839144 {
 static class FastReader{
  BufferedReader br ;
  StringTokenizer st;
  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in)); 
  }
  String next() {
   while(st==null || !st.hasMoreElements()){try {st = new StringTokenizer(br.readLine());}catch(IOException e) {e.printStackTrace();}}
   return st.nextToken();
  }
  int nextInt(){return Integer.parseInt(next());}
  long nextLong(){return  Long.parseLong(next());}
  double nextDouble(){return Double.parseDouble(next());}
  float nextFloat(){return Float.parseFloat(next());}
  String nextLine(){
   String str = "";
   try {
    str = br.readLine();
   }catch(IOException e) {
    e.printStackTrace();
   }
   return str ;
  }
 }
 public static void main(String[] args) {
  long start2 = System.currentTimeMillis();
  FastReader fs = new FastReader();
  //int t = fs.nextInt();
  int t =1;
  while(t-->0) {
   int n = fs.nextInt();
   int m = fs.nextInt();
   long k = fs.nextLong();
   ArrayList<Long> a = new ArrayList<>();
   ArrayList<Long> b = new ArrayList<>();
   for(int i =0;i<n;i++) {
    a.add(fs.nextLong());
   }
   Collections.sort(a);
   for(int i =0;i<m;i++) {
    b.add(fs.nextLong());
   }
   Collections.sort(b);
   int i =0,j=0,cnt=0;
   while(i<n&&j<m) {
    if(a.get(i)>b.get(j)+k) {
     j++;
    }
    else if(a.get(i)<b.get(j)-k) {
     i++;
    }
    else {
     j++;i++;cnt++;
    }
   }
   System.out.println(cnt);
  }  
  long end2 = System.currentTimeMillis();
  //System.out.println("time :"+(end2-start2));
 // sc.close();
 }
 private static int g(int n) {
  return n ^ (n >> 1);
 }

}
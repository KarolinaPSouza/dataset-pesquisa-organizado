import java.io.*;
import java.util.*;


public class entry_1633820 {
 static FastReader sc=null;


 public static void main(String[] args) {
  sc=new FastReader();
  int n=sc.nextInt();
  int a[]=sc.readArray(n);
  long max=Long.MIN_VALUE,curr=0;
  for(int i=0;i<n;i++) {
   curr=Math.max(a[i], curr+a[i]);
   max=Math.max(curr, max);
  }
  System.out.println(max);


 }





 static void ruffleSort(int a[]) {
  ArrayList<Integer> al=new ArrayList<>();
  for(int i:a)al.add(i);
  Collections.sort(al);
  for(int i=0;i<a.length;i++)a[i]=al.get(i);
 }
 static void ruffleSort(long a[]) {
  ArrayList<Long> al=new ArrayList<>();
  for(long i:a)al.add(i);
  Collections.sort(al);
  for(int i=0;i<a.length;i++)a[i]=al.get(i);
 }

 static int[] reverse(int a[]) {
  ArrayList<Integer> al=new ArrayList<>();
  for(int i:a)al.add(i);
  Collections.sort(al,Collections.reverseOrder());
  for(int i=0;i<a.length;i++)a[i]=al.get(i);
  return a;
 }







 static void print(long a[]) {
  for(long e:a) {
   System.out.print(e+" ");
  }
  System.out.println();
 }
 static void print(char a[]) {
  for(char e:a) {
   System.out.print(e);
  }
  System.out.println();
 }


 static void print(int a[]) {
  for(int e:a) {
   System.out.print(e+" ");
  }
  System.out.println();
 }


 static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int[] readArray(int n) {
      int a[]=new int [n];
      for(int i=0;i<n;i++) {
       a[i]=sc.nextInt();
      }
      return a;
     }
    } 
}






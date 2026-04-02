import java.util.*;
import java.io.*;

 public class entry_573358 {
// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void sort(int[] a){List<Integer> l=new ArrayList<>();for(int z:a){l.add(z);}Collections.sort(l);for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}

//......................................@uthor_Alx..............................................
   static int f(int[] a, int[] b){
     return a[1]-b[1];
   }

   public static void main(String[] args) throws  IOException{
               assign();
              int n=int_v(read());
              int[] arr=int_arr();
              long[] dp=new long[n];
              long res=arr[0];dp[0]=res;
              for(int i=1;i<n;i++){
               dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
               res=Math.max(res,dp[i]);
              }

               out.write(res+"");
                        out.flush();
 }
}